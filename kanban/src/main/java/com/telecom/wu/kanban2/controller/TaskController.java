package com.telecom.wu.kanban2.controller;

import com.telecom.wu.kanban2.domain.Task;
import com.telecom.wu.kanban2.domain.TaskStatus;
import com.telecom.wu.kanban2.domain.TaskType;
import com.telecom.wu.kanban2.service.TaskService;
import com.telecom.wu.kanban2.utils.Constants;
import com.telecom.wu.kanban2.utils.TaskMoveAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController // @RestController is roughly equivalent to (@Controller + @ResponseBody)
// which has the role of @Control components, and control the display of the body part on the web side.
@CrossOrigin(origins = "*", allowedHeaders = "*") // As the name implies, the annotation enables Cross-Origin Resource Sharing (CORS) on the server.
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks") // @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    Collection<Task> findAllTasks() {
        return this.taskService.findAllTasks();
    }

    @GetMapping("/task_types")
    Collection<TaskType> findAllTaskTypes() {
        return this.taskService.findAllTaskTypes();
    }

    @GetMapping("/task_status")
    Collection<TaskStatus> findAllTaskStatus() {
        return this.taskService.findAllTaskStatus();
    }

    @PostMapping("/tasks") //Only when the request is POST, the method needs to accept the content of the post request and verify it with the valid annotation.
    Task createTask(@Valid @RequestBody Task task) {

        return this.taskService.createTask(task);
    }
    // The HTTP PATCH request body describes how the target resource should be modified to produce a new version.
    @PatchMapping("/tasks/{id}") // because the PUT replaces a resource entirely, it's not a suitable method to apply partial updates elegantly
    Task moveTask(@RequestBody TaskMoveAction taskMoveAction, @PathVariable Long id) {

        Task task = this.taskService.findTask(id);
        // Determine the task change by judging the MoveAction to right or left.
        if (Constants.MOVE_LEFT_ACTION.equals(taskMoveAction.getAction())) {

            task = this.taskService.moveLeftTask(task);
        }
        else if (Constants.MOVE_RIGHT_ACTION.equals(taskMoveAction.getAction())) {

            task = this.taskService.moveRightTask(task);
        }
        else {
            throw new IllegalStateException();
        }
        // Return the result of the taskmoveaction
        return task;
    }
}