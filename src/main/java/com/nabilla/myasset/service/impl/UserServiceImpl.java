package com.nabilla.myasset.service.impl;

import com.nabilla.myasset.exception.DataNotFoundException;
import com.nabilla.myasset.model.Role;
import com.nabilla.myasset.model.User;
import com.nabilla.myasset.repository.RoleRepository;
import com.nabilla.myasset.repository.UserRepository;
import com.nabilla.myasset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
//        Role role = roleRepository.findByName("ROLE_ADMIN");
//        if(role == null){
//            role = checkRoleExist();
//        }
//        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Override
    public User getById(Long id) {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            throw new DataNotFoundException("User with Id : "+id+" Not Found");
        }
    }

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }
}
