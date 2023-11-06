package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
