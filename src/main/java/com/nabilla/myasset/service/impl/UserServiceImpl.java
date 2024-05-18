package com.nabilla.myasset.service.impl;

import com.nabilla.myasset.exception.UserNotFoundException;
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
    public User saveUser(User user) {
        return repo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> opt = repo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            throw new UserNotFoundException("User with Id : "+id+" Not Found");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public void updateUser(User user) {
        repo.save(user);
    }
}
