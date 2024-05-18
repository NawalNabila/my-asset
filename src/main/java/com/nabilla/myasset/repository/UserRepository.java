package com.nabilla.myasset.repository;

import com.nabilla.myasset.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
