package services;

import models.Task;

import java.util.List;

public interface TaskService {
    //Save task
    int saveTask(Task task);

    //Get a single task
    Task getTaskByID(int id);

    //Get all tasks
    List<Task> getAllTasks();

    //Update a task
    void updateTask(int id, Task task);

    //Delete a task
    void deleteTask(int id);
}
