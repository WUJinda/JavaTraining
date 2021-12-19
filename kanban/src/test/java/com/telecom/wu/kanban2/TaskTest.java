package com.telecom.wu.kanban2;


import com.telecom.wu.kanban2.domain.Developer;
import com.telecom.wu.kanban2.domain.Task;
import com.telecom.wu.kanban2.domain.TaskStatus;
import com.telecom.wu.kanban2.domain.TaskType;
import com.telecom.wu.kanban2.service.DeveloperService;
import com.telecom.wu.kanban2.service.TaskService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
public class TaskTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private DeveloperService developerService;

    @Test
    public void testAddDeveloperToTask() {

        Developer developer = new Developer();

        Task task = new Task();

        task.addDeveloper(developer);

        Assert.assertEquals(1, task.getDevelopers().size());
    }

    @Test
    public void testFindAllTasks() {

        Collection<Task> tasks = this.taskService.findAllTasks();

        Assert.assertEquals(1, tasks.size());
    }

    @Test
    public void testFindAllTaskTypes() {

        Collection<TaskType> taskTypes = this.taskService.findAllTaskTypes();

        Assert.assertEquals(2, taskTypes.size());
    }

    @Test
    public void testFindAllTaskStatus() {

        Collection<TaskStatus> taskStatus = this.taskService.findAllTaskStatus();

        Assert.assertEquals(4, taskStatus.size());
    }
}
