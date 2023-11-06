package com.academy.logistics_department.service;

import com.academy.logistics_department.model.entity.Route;

import java.sql.Driver;
import java.util.List;

public interface DriverService {
    List<Route> getAllRoutes();
    Route getDriversCurrentRoute(Driver driver);
    boolean changeApplicationStatus(Integer id);
}
