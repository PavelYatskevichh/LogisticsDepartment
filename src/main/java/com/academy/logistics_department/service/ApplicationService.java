package com.academy.logistics_department.service;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    List<ApplicationDto> getAllActiveDriversApplications(RouteDto routeDto);
    List<ApplicationDto> getAllDeliveredDriversApplications(RouteDto routeDto);
    Optional<ApplicationStatusEnum> changeApplicationStatus(RouteDto route, Integer applicationId);
}
