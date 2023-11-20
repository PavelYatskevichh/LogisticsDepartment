package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.mappers.ApplicationMapper;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.repository.ApplicationRepository;
import com.academy.logistics_department.model.repository.ApplicationStatusRepository;
import com.academy.logistics_department.service.ApplicationService;
import com.academy.logistics_department.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final RouteService routeService;
    private final ApplicationRepository applicationRepository;
    private final ApplicationStatusRepository applicationStatusRepository;
    private final ApplicationMapper applicationMapper;

    @Override
    public List<ApplicationDto> getAllActiveDriversApplications(RouteDto routeDto) {
        List<ApplicationDto> applications = routeDto.getApplications();
        return applications.stream()
                .filter(a ->
                        a.getStatus().getStatusName() == ApplicationStatusEnum.WAITING_FOR_LOADING
                                || a.getStatus().getStatusName() == ApplicationStatusEnum.ON_THE_WAY)
                .toList();
    }

    @Override
    public List<ApplicationDto> getAllDeliveredDriversApplications(RouteDto routeDto) {
        List<ApplicationDto> applications = routeDto.getApplications();
        return applications.stream()
                .filter(a ->
                        a.getStatus().getStatusName() == ApplicationStatusEnum.DELIVERED)
                .toList();
    }

    @Override
    public Optional<ApplicationStatusEnum> changeApplicationStatus(RouteDto routeDto, Integer applicationId) {
        Optional<Application> optionalApplication = applicationRepository.findById(applicationId);

        try {
            Application application = optionalApplication.orElseThrow();
            ApplicationStatusEnum applicationStatusName = application.getStatus().getStatusName();
            ApplicationStatus newApplicationStatus = applicationStatusRepository.getReferenceById(applicationStatusName.ordinal() + 2);
            application.setStatus(newApplicationStatus);

            applicationRepository.save(application);

            routeService.completeRoute(routeDto);

            return Optional.ofNullable(application.getStatus().getStatusName());

        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }
}
