package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Route;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    @Override
    @EntityGraph("Route.applications")
    List<Route> findAll();
}
