package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.mappers.ApplicationMapper;
import com.academy.logistics_department.mappers.ApplicationStatusMapper;
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

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final RouteService routeService;
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    private final ApplicationStatusRepository applicationStatusRepository;
    private final ApplicationStatusMapper applicationStatusMapper;

    @Override
    public List<ApplicationDto> getAllActiveDriversApplications(RouteDto routeDto) {
        List<ApplicationDto> applications = routeDto.getApplications();
        return applications.stream()
                .filter(a -> a.getStatus().getStatusName() == ApplicationStatusEnum.WAITING_FOR_LOADING
                        || a.getStatus().getStatusName() == ApplicationStatusEnum.ON_THE_WAY)
                .toList();
    }

    @Override
    public List<ApplicationDto> getAllDeliveredDriversApplications(RouteDto routeDto) {
        List<ApplicationDto> applications = routeDto.getApplications();
        return applications.stream()
                .filter(a -> a.getStatus().getStatusName() == ApplicationStatusEnum.DELIVERED)
                .toList();
    }

    @Override
    public ApplicationStatusEnum changeApplicationStatus(RouteDto routeDto, Integer applicationId) {
        List<ApplicationDto> applicationDtoList = routeDto.getApplications();
        ApplicationDto applicationDto = null;
        for (ApplicationDto a : applicationDtoList) {
            if (a.getId().equals(applicationId)) {
                applicationDto = a;
            }
        }

        assert applicationDto != null;
        ApplicationStatus newApplicationStatus = applicationStatusRepository.getReferenceById(applicationDto.getStatus().getId() + 1);
        applicationDto.setStatus(applicationStatusMapper.toDto(newApplicationStatus));

        Application application = applicationRepository.getReferenceById(applicationId);
        applicationMapper.updateModel(applicationDto, application);
        applicationRepository.save(application);
//        applicationRepository.updateApplicationStatus(applicationId, newApplicationStatus);

        routeService.completeRoute(routeDto);

        return applicationDto.getStatus().getStatusName();
    }
}
