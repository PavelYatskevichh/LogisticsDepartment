package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.mappers.ApplicationMapper;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import com.academy.logistics_department.model.entity.Route;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.repository.ApplicationRepository;
import com.academy.logistics_department.model.repository.ApplicationStatusRepository;
import com.academy.logistics_department.service.ApplicationService;
import com.academy.logistics_department.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final RouteService routeService;
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    private final ApplicationStatusRepository applicationStatusRepository;

    @Override
    public List<ApplicationDto> getAllActiveCustomersApplications(Integer customerId) {
        List<Application> applications = applicationRepository.findAllApplicationsByCustomerId(customerId);
        return applications.stream()
                .filter(a -> a.getStatus().getStatusName() != ApplicationStatusEnum.DELIVERED)
                .map(applicationMapper::toDto)
                .toList();
    }

    @Override
    public List<ApplicationDto> getAllDeliveredCustomersApplications(Integer customerId) {
        List<Application> applications = applicationRepository.findAllApplicationsByCustomerId(customerId);
        return applications.stream()
                .filter(a -> a.getStatus().getStatusName() == ApplicationStatusEnum.DELIVERED)
                .map(applicationMapper::toDto)
                .toList();
    }

    @Override
    public void createApplication(Application application) {

    }

    @Override
    public void changeApplication(Integer id) {

    }

    @Override
    public ApplicationDto getCustomersApplicationDto(Integer customerId, Integer applicationId) {
        Application application = applicationRepository.getReferenceById(applicationId);
        List<Application> applications = applicationRepository.findAllApplicationsByCustomerId(customerId);
        if (applications.contains(application)) {
            return applicationMapper.toDto(application);
        } else {
            throw new RuntimeException("The driver (id = " + customerId + ") doesn't have such route (id = " + applicationId + ").");
        }
    }

    @Override
    public List<ApplicationDto> getAllUnallocatedApplications() {
        List<Application> applications = applicationRepository.findAll();
        return applications.stream()
                .filter(a -> a.getStatus().getStatusName() == ApplicationStatusEnum.PROCESSING)
                .map(applicationMapper::toDto)
                .toList();
    }

    @Override
    public List<ApplicationDto> getAllActiveDriversApplications(RouteDto routeDto) {
        List<Application> applications = applicationRepository.findAllApplicationsByDriveId(routeDto.getDriver().getId());
        return applications.stream()
                .filter(a -> a.getStatus().getStatusName() == ApplicationStatusEnum.WAITING_FOR_LOADING
                        || a.getStatus().getStatusName() == ApplicationStatusEnum.ON_THE_WAY)
                .map(applicationMapper::toDto)
                .toList();
    }

    @Override
    public List<ApplicationDto> getAllDeliveredDriversApplications(RouteDto routeDto) {
        List<Application> applications = applicationRepository.findAllApplicationsByDriveId(routeDto.getDriver().getId());
        return applications.stream()
                .filter(a -> a.getStatus().getStatusName() == ApplicationStatusEnum.DELIVERED)
                .map(applicationMapper::toDto)
                .toList();
    }

    @Override
    public ApplicationStatusEnum changeApplicationStatus(RouteDto routeDto, Integer applicationId) {
        Application application = applicationRepository.getReferenceById(applicationId);
        ApplicationStatus newApplicationStatus = applicationStatusRepository.getReferenceById(application.getStatus().getId() + 1);
        application.setStatus(newApplicationStatus);

        applicationRepository.save(application);

        routeService.completeRoute(routeDto);

        return application.getStatus().getStatusName();
    }
}
