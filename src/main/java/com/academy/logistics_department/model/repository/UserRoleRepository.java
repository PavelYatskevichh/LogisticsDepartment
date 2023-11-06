package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
