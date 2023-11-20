package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.mappers.RouteMapper;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.Route;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.enums.RouteStatusEnum;
import com.academy.logistics_department.model.repository.RouteRepository;
import com.academy.logistics_department.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    @Override
    public List<RouteDto> getDriversAllCompletedRoutes(Integer driverId) {
        List<Route> routeList = routeRepository.findAllRoutesByDriverId(driverId);
        List<RouteDto> result = new ArrayList<>();

        for (Route route : routeList) {
            RouteDto routeDto = routeMapper.toDto(route);
            if (routeDto.getStatus() == RouteStatusEnum.COMPLETED) {
                result.add(routeDto);
            }
        }
        return result;
    }

    @Override
    public RouteDto getDriversCurrentRoute(Integer driverId) {
        List<Route> routeList = routeRepository.findAllRoutesByDriverId(driverId);

        for (Route route : routeList) {
            RouteDto routeDto = routeMapper.toDto(route);
            if (routeDto.getStatus() == RouteStatusEnum.CURRENT) {
                return routeDto;
            }
        }
        return null;
    }

    @Override
    public RouteDto getRouteById(Integer driverId, Integer routeId) {
        Route route = routeRepository.getReferenceById(routeId);
        List<Route> routes = routeRepository.findAllRoutesByDriverId(driverId);
        if (routes.contains(route)) {
            return routeMapper.toDto(route);
        } else {
            throw new RuntimeException("The driver (id = " + driverId + ") doesn't have such route (id = " + routeId + ").");
        }
    }

    @Override
    public boolean completeRoute(RouteDto routeDto) {
        List<ApplicationDto> applications = routeDto.getApplications();

        if (applications.stream().allMatch(a -> a.getStatus().getStatusName().equals(ApplicationStatusEnum.DELIVERED))) {
            RouteStatusEnum newRouteStatus = RouteStatusEnum.COMPLETED;
            routeDto.setStatus(newRouteStatus);
            return true;
        } else {
            return false;
        }
    }
}
