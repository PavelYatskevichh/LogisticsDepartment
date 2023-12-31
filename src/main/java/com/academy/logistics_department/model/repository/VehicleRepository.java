package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
