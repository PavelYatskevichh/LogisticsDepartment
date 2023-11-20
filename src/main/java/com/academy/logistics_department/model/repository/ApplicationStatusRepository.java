package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatus, Integer> {
}
