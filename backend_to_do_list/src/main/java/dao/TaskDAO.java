package dao;

import models.Task;

import java.util.List;

public interface TaskDAO {
    //Save task
    int saveTask(Task task);

    //Get a single task
    Task getTask(int id);

    //Get all tasks
    List<Task> getAllTasks();

    //Update a task
    void updateTask(int id, Task task);

    //Delete a task
    void deleteTask(int id);
}
