package com.academy.logistics_department.service;

import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.model.entity.Route;
import com.academy.logistics_department.model.enums.RouteStatusEnum;

import java.util.List;

public interface RouteService {
    List<RouteDto> getDriversAllCompletedRoutes(Integer driverId);
    RouteDto getDriversCurrentRoute(Integer driverId);
    RouteDto getRouteById(Integer driverId, Integer routeId);
    boolean completeRoute(RouteDto routeDto);
}
