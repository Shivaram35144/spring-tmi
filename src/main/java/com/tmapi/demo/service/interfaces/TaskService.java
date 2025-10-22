package com.tmapi.demo.service.interfaces;

import com.tmapi.demo.model.Task;
import com.tmapi.demo.model.User;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
    Task assignTaskToUser(Long taskId, Long userId);
    List<Task> unassignedTasks();
}
