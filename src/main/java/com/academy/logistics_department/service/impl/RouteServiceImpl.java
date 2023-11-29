package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.mappers.RouteMapper;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import com.academy.logistics_department.model.entity.Route;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.enums.RouteStatusEnum;
import com.academy.logistics_department.model.repository.*;
import com.academy.logistics_department.service.ApplicationService;
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
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final ApplicationRepository applicationRepository;
    private final ApplicationStatusRepository applicationStatusRepository;
    private final Integer WAITING_FOR_LOAD_STATUS_ID = 2;

    @Override
    public List<RouteDto> getAllDriversCompletedRoutes(Integer driverId) {
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
    public List<RouteDto> getDriversCurrentRoutes(Integer driverId) {
        List<Route> routeList = routeRepository.findAllRoutesByDriverId(driverId);
        List<RouteDto> result = new ArrayList<>();

        for (Route route : routeList) {
            RouteDto routeDto = routeMapper.toDto(route);
            if (routeDto.getStatus() == RouteStatusEnum.CURRENT) {
                result.add(routeDto);
            }
        }
        return result;
    }

    @Override
    public RouteDto getDriversRouteById(Integer driverId, Integer routeId) {
        Route route = routeRepository.getReferenceById(routeId);
        List<Route> routes = routeRepository.findAllRoutesByDriverId(driverId);
        if (routes.contains(route)) {
            return routeMapper.toDto(route);
        } else {
            throw new RuntimeException("The driver (id = " + driverId + ") doesn't have such route (id = " + routeId + ").");
        }
    }

    @Override
    public RouteDto getRouteById(Integer routeId) {
        return routeMapper.toDto(routeRepository.getReferenceById(routeId));
    }

    @Override
    public void completeRoute(RouteDto routeDto) {
        List<ApplicationDto> applications = routeDto.getApplications();

        if (applications.stream().allMatch(a -> a.getStatus().getStatusName().equals(ApplicationStatusEnum.DELIVERED))) {
            RouteStatusEnum newRouteStatus = RouteStatusEnum.COMPLETED;
            routeDto.setStatus(newRouteStatus);
        }
    }

    @Override
    public List<RouteDto> getAllActiveRoutes() {
        List<Route> routes = routeRepository.findAll();
        return routes.stream()
                .map(routeMapper::toDto)
                .filter(r -> r.getStatus() == RouteStatusEnum.CURRENT)
                .toList();
    }

    @Override
    public List<RouteDto> getAllCompletedRoutes() {
        List<Route> routes = routeRepository.findAll();
        return routes.stream()
                .map(routeMapper::toDto)
                .filter(r -> r.getStatus() == RouteStatusEnum.COMPLETED)
                .toList();
    }

    @Override
    public void saveRoute(Integer managerId, Integer driverId, Integer vehicleId, Integer... applicationIds) {
        List<Application> applications = new ArrayList<>();
        ApplicationStatus applicationStatus = applicationStatusRepository.getReferenceById(WAITING_FOR_LOAD_STATUS_ID);
        for (Integer applicationId : applicationIds) {
            Application application = applicationRepository.getReferenceById(applicationId);
            if (application.getStatus().getStatusName() == ApplicationStatusEnum.PROCESSING) {
                application.setStatus(applicationStatus);
                applications.add(application);
            } else {
                throw new RuntimeException("Application #" + applicationId + " is already allocated.");
            }
        }

        Route route = Route.builder()
                .manager(userRepository.getReferenceById(managerId))
                .driver(userRepository.getReferenceById(driverId))
                .vehicle(vehicleRepository.getReferenceById(vehicleId))
                .applications(applications)
                .build();

        routeRepository.save(route);
    }
}
