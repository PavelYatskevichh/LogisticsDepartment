package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    @Query("FROM Application a WHERE a.customer.id = :customerId")
    List<Application> findAllApplicationsByCustomerId(Integer customerId);
    @Query("SELECT applications FROM Route r WHERE r.driver.id = :driverId")
    List<Application> findAllApplicationsByDriveId(Integer driverId);
}
