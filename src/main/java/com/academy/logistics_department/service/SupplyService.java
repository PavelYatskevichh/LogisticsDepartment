package com.academy.logistics_department.service;

import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.Route;

import java.util.List;

public interface SupplyService {
    List<Application> getAllApplications();
    List<Application> getAllManagersApplications();
    void createRoute(Route route);
    void changeRoute(Integer id);

}
