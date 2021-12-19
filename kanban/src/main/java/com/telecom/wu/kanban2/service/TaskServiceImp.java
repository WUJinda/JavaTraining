package com.telecom.wu.kanban2.service;

import com.telecom.wu.kanban2.dao.ChangeLogRepository;
import com.telecom.wu.kanban2.dao.TaskRepository;
import com.telecom.wu.kanban2.dao.TaskStatusRepository;
import com.telecom.wu.kanban2.dao.TaskTypeRepository;
import com.telecom.wu.kanban2.domain.ChangeLog;
import com.telecom.wu.kanban2.domain.Task;
import com.telecom.wu.kanban2.domain.TaskStatus;
import com.telecom.wu.kanban2.domain.TaskType;
import com.telecom.wu.kanban2.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Autowired
    private TaskTypeRepository taskTypeRepository;

    @Autowired
    private ChangeLogRepository changeLogRepository;


    @Override
    @Transactional(readOnly = true)
    public Collection<Task> findAllTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Task findTask(Long id) {
        return this.taskRepository.findById(id).orElse(null);
    }

    // Move to the right according to this state sequence: TO DO -> DOING -> TEST -> DONE
    @Override
    @Transactional
    public Task moveRightTask(Task task) {
        TaskStatus targetStatus = this.getTargetStatusForMoveRight(task.getStatus());

        return this.changeTaskStatus(task, targetStatus);
    }
    @Transactional(readOnly = true)
    private TaskStatus getTargetStatusForMoveRight(TaskStatus status) {


        // Create a task state based on the task state ID.
        // In my opinion, we can set the statuses with an ascending order by adding 1L.
        TaskStatus todoStatus = this.findTaskStatus(Constants.TASK_STATUS_TODO_ID);

        TaskStatus doingStatus = this.findTaskStatus(Constants.TASK_STATUS_DOING_ID);

        TaskStatus testStatus = this.findTaskStatus(Constants.TASK_STATUS_TEST_ID);

        TaskStatus doneStatus = this.findTaskStatus(Constants.TASK_STATUS_DONE_ID);

        TaskStatus result = null;
        //If the result is not null, then the corresponding task status is returned.
        if (status != null) {

            if (status.equals(todoStatus)) {

                result = doingStatus;
            }
            else if (status.equals(doingStatus)) {

                result = testStatus;
            }
            else if (status.equals(testStatus)) {

                result = doneStatus;
            }
            else if (status.equals(doneStatus)) {

                throw new IllegalStateException();
            }
        }
        else {
            throw new IllegalArgumentException();
        }

        return result;
    }
    // Move to the left according to this state sequence: TO DO <- DOING <- TEST <- DONE
    @Override
    @Transactional
    public Task moveLeftTask(Task task) {
        TaskStatus targetStatus = this.getTargetStatusForMoveLeft(task.getStatus());

        return this.changeTaskStatus(task, targetStatus);
    }
    @Transactional(readOnly = true)
    private TaskStatus getTargetStatusForMoveLeft(TaskStatus status) {
        // same as MoveToRight
        TaskStatus todoStatus = this.findTaskStatus(Constants.TASK_STATUS_TODO_ID);

        TaskStatus doingStatus = this.findTaskStatus(Constants.TASK_STATUS_DOING_ID);

        TaskStatus testStatus = this.findTaskStatus(Constants.TASK_STATUS_TEST_ID);

        TaskStatus doneStatus = this.findTaskStatus(Constants.TASK_STATUS_DONE_ID);

        TaskStatus result = null;

        if (status != null) {

            if (status.equals(todoStatus)) {

                throw new IllegalStateException();
            }
            else if (status.equals(doingStatus)) {

                result = todoStatus;
            }
            else if (status.equals(testStatus)) {

                result = doingStatus;
            }
            else if (status.equals(doneStatus)) {

                result = testStatus;
            }
        }
        else {
            throw new IllegalArgumentException();
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<TaskType> findAllTaskTypes() {
        return this.taskTypeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<TaskStatus> findAllTaskStatus() {
        return this.taskStatusRepository.findAll();
    }

    @Override
    @Transactional
    public Task changeTaskStatus(Task task, TaskStatus targetStatus) {
        // We can modify changeLog by resetting the attribute value.
        task = this.taskRepository.save(task);
        ChangeLog changeLog = new ChangeLog();
        changeLog.setOccured(LocalDateTime.now());
        changeLog.setSourceStatus(task.getStatus());
        changeLog.setTargetStatus(targetStatus);
        changeLog.setTask(task);
        this.changeLogRepository.save(changeLog);

        task.setStatus(targetStatus);
        return task;
    }

    @Override
    @Transactional(readOnly = true)
    public TaskStatus findTaskStatus(Long id) {
        return this.taskStatusRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public TaskType findTaskType(Long id) {
        return this.taskTypeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ChangeLog> findChangeLogsForTask(Task task) {
        return this.changeLogRepository.findByTaskId(task.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean displayMoveRightForTask(Task task) {
        TaskStatus done = this.findTaskStatus(Constants.TASK_STATUS_DONE_ID);

        return !task.getStatus().equals(done);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean displayMoveLeftForTask(Task task) {
        TaskStatus todo = this.findTaskStatus(Constants.TASK_STATUS_TODO_ID);

        return !task.getStatus().equals(todo);
    }

    @Override
    @Transactional
    public Task createTask(Task task) {
        TaskStatus todo = this.findTaskStatus(Constants.TASK_STATUS_TODO_ID);

        task.setStatus(todo);

        task.setCreated(LocalDate.now());

        return this.taskRepository.save(task);
    }

    @Override
    @Transactional
    public void deleteTask(Task task) {
        task = this.taskRepository.save(task);

        List<ChangeLog> changeLogs = this.changeLogRepository.findByTaskId(task.getId());
        // Traverse all the logs to delete them.
        for (ChangeLog changeLog : changeLogs) {

            this.changeLogRepository.delete(changeLog);
        }

        this.taskRepository.delete(task);
    }

}
