package com.nabilla.myasset.service;

import com.nabilla.myasset.model.Role;

import java.util.List;

public interface RoleService {
    public void save(Role role);
    public List<Role> getList();
    public Role getById(Long id);
}
