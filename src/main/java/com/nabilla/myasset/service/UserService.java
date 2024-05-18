package com.nabilla.myasset.service;

import com.nabilla.myasset.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public void updateUser(User user);
}
