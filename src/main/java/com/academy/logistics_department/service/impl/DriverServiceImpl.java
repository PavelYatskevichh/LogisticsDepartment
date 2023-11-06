package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.Route;
import com.academy.logistics_department.model.enums.StatusEnum;
import com.academy.logistics_department.model.repository.ApplicationRepository;
import com.academy.logistics_department.model.repository.RouteRepository;
import com.academy.logistics_department.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final ApplicationRepository applicationRepository;
    private final RouteRepository routeRepository;

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll(Sort.by("id"));
    }

    @Override
    public Route getDriversCurrentRoute(Driver driver) {
        return routeRepository.getReferenceById(1);
    }

    @Override
    public boolean changeApplicationStatus(Integer id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);

        if (optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.getStatus()
                    .setStatusName(StatusEnum
                            .valueOf(application.getStatus().getStatusName().ordinal() + 1
                            )
                    );
            return true;
        }

        return false;
    }
}
