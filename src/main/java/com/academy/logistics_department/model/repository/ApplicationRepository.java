package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Application;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    @Override
    @EntityGraph("Application.items")
    List<Application> findAll();
}
