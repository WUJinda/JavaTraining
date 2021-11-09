package com.example.kanban.service;

import com.example.kanban.domain.Task;
import com.example.kanban.domain.TaskStatus;
import com.example.kanban.domain.TaskType;

import java.util.Collection;

public interface TaskService {

    public Collection<Task> findAllTasks();
    public Task findTask(Long id);
    public Task moveRightTask(Task task);
    public Task moveLeftTask(Task task);

    public Collection<TaskType> findAllTaskTypes();

    public Collection<TaskStatus> findAllTaskStatus();

}
