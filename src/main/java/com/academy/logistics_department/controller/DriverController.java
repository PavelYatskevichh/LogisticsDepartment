package com.academy.logistics_department.controller;

import com.academy.logistics_department.model.entity.Route;
import com.academy.logistics_department.service.DriverService;
import com.academy.logistics_department.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping(value = "/driver")
    public List<Route> getAllApplications() {

        return driverService.getAllRoutes();
    }
}
