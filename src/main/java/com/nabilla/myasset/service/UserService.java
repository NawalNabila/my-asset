package com.nabilla.myasset.service;

import com.nabilla.myasset.model.User;

import java.util.List;

public interface UserService {

    public void save(User user);
    public List<User> getList();
    public User getById(Long id);
}
