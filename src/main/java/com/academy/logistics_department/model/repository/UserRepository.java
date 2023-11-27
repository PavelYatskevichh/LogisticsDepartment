package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
}
