package dao;

import models.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImp implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int saveTask(Task task) {
        sessionFactory.getCurrentSession().save(task);
        return task.getId();
    }

    @Override
    public Task getTask(int id) {
        return sessionFactory.getCurrentSession().get(Task.class, id);
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = sessionFactory.getCurrentSession().createQuery("from Task").list();
        return tasks;
    }

    @Override
    public void updateTask(int id, Task task) {
        Session session = sessionFactory.getCurrentSession();
        Task previousTask = session.byId(Task.class).load(id);
        previousTask.setDate(task.getDate());
        previousTask.setTitle(task.getTitle());
        previousTask.setDescription(task.getDescription());
        session.flush();
    }

    @Override
    public void deleteTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Task taskToDelete = session.byId(Task.class).load(id);
        session.delete(taskToDelete);
    }
}
