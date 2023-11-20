package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
