package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
