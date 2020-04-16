package controllers;

import models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.TaskService;

import java.util.List;

@CrossOrigin("*")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    //Get all the tasks
    @GetMapping("/api/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    //Save a task
    @PostMapping("/api/save/task")
    public ResponseEntity<String> saveTask(@RequestBody Task task) {
        int taskId = taskService.saveTask(task);
        return ResponseEntity.ok().body("Task created with ID:"+taskId);
    }

    //Get a task by id
    @GetMapping(value = "api/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(taskService.getTaskByID(id));
    }

    //Update a task by id
    @PutMapping(value = "/api/task/{id}")
    public ResponseEntity<String > updateTaskById(@PathVariable("id") int id, @RequestBody Task task) {
        taskService.updateTask(id, task);
        return ResponseEntity.ok().body("Task has been updated");
    }

    //Delete a task by id
    @DeleteMapping(value = "/api/task/{id}")
    public ResponseEntity<String> deleteTaskByI(@PathVariable("id") int id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().body("Task has been deleted successfully");
    }
}
