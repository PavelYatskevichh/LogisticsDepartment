package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
//    @Modifying
//    @Query("update Application a set a.status = :status where u.id = :applicationId")
//    void updateApplicationStatus(@Param(value = "applicationId") Integer applicationId, @Param(value = "status") ApplicationStatus status);
}
