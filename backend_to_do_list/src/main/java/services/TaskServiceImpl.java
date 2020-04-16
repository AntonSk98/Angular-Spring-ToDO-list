package services;

import dao.TaskDAO;
import models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Override
    @Transactional
    public int saveTask(Task task) {
        taskDAO.saveTask(task);
        return task.getId();
    }

    @Override
    @Transactional
    public Task getTaskByID(int id) {
        return taskDAO.getTask(id);
    }

    @Override
    @Transactional
    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @Override
    @Transactional
    public void updateTask(int id, Task task) {
        taskDAO.updateTask(id, task);
    }

    @Override
    @Transactional
    public void deleteTask(int id) {
        taskDAO.deleteTask(id);
    }
}
