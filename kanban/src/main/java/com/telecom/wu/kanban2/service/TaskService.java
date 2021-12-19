package com.telecom.wu.kanban2.service;

import com.telecom.wu.kanban2.domain.ChangeLog;
import com.telecom.wu.kanban2.domain.Task;
import com.telecom.wu.kanban2.domain.TaskStatus;
import com.telecom.wu.kanban2.domain.TaskType;

import java.util.Collection;

public interface TaskService {
    public Collection<Task> findAllTasks();

    public Task changeTaskStatus(Task task, TaskStatus targetStatus);

    public Task findTask(Long id);

    public TaskStatus findTaskStatus(Long id);

    public TaskType findTaskType(Long id);

    public Collection<ChangeLog> findChangeLogsForTask(Task task);

    public boolean displayMoveRightForTask(Task task);

    public boolean displayMoveLeftForTask(Task task);

    public Task moveRightTask(Task task);

    public Task moveLeftTask(Task task);

    public Task createTask(Task task);

    public void deleteTask(Task task);

    public Collection<TaskType> findAllTaskTypes();

    public Collection<TaskStatus> findAllTaskStatus();
}
