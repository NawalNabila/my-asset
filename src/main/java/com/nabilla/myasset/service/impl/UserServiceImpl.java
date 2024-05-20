package com.nabilla.myasset.service.impl;

import com.nabilla.myasset.exception.DataNotFoundException;
import com.nabilla.myasset.model.User;
import com.nabilla.myasset.repository.UserRepository;
import com.nabilla.myasset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public User getById(Long id) {
        Optional<User> opt = repo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            throw new DataNotFoundException("User with Id : "+id+" Not Found");
        }
    }

    @Override
    public List<User> getList() {
        return repo.findAll();
    }
}
