package com.nabilla.myasset.service.impl;

import com.nabilla.myasset.exception.DataNotFoundException;
import com.nabilla.myasset.model.Role;
import com.nabilla.myasset.repository.RoleRepository;
import com.nabilla.myasset.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repo;

    @Override
    public void save(Role role) {
        repo.save(role);
    }

    @Override
    public Role getById(Long id) {
        Optional<Role> opt = repo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            throw new DataNotFoundException("Role with Id : "+id+" Not Found");
        }
    }

    @Override
    public List<Role> getList() {
        return repo.findAll();
    }
}
