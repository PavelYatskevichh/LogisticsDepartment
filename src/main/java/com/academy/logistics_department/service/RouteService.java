package com.academy.logistics_department.service;

import com.academy.logistics_department.dto.RouteDto;

import java.util.List;

public interface RouteService {
    List<RouteDto> getAllDriversCompletedRoutes(Integer driverId);
    RouteDto getDriversCurrentRoute(Integer driverId);
    RouteDto getDriversRouteById(Integer driverId, Integer routeId);
    RouteDto getRouteById(Integer routeId);
    boolean completeRoute(RouteDto routeDto);
    List<RouteDto> getAllActiveRoutes();
    List<RouteDto> getAllCompletedRoutes();
}
