package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    @Query("FROM Route r WHERE r.driver.id = :driverId")
    List<Route> findAllRoutesByDriverId(Integer driverId);
}
