package com.academy.logistics_department.service;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDto> getAllActiveDriversApplications(RouteDto routeDto);
    List<ApplicationDto> getAllDeliveredDriversApplications(RouteDto routeDto);
    ApplicationStatusEnum changeApplicationStatus(RouteDto routeDto, Integer applicationId);
    List<ApplicationDto> getAllActiveCustomersApplications(Integer customerId);
    List<ApplicationDto> getAllDeliveredCustomersApplications(Integer customerId);
    void createApplication(Application application);
    void changeApplication(Integer id);
    ApplicationDto getCustomersApplicationDto(Integer customerId, Integer applicationId);
    List<ApplicationDto> getAllUnallocatedApplications();
}
