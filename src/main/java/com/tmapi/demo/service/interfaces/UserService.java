package com.tmapi.demo.service.interfaces;

import com.tmapi.demo.model.Task;
import com.tmapi.demo.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
    List<Task> getTasksByUserId(Long userId);
}
