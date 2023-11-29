package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.AddressDto;
import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.ItemDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.mappers.AddressMapper;
import com.academy.logistics_department.mappers.ApplicationMapper;
import com.academy.logistics_department.mappers.ItemMapper;
import com.academy.logistics_department.model.entity.Address;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import com.academy.logistics_department.model.entity.Item;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.repository.*;
import com.academy.logistics_department.service.ApplicationService;
import com.academy.logistics_department.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final RouteService routeService;
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    private final ApplicationStatusRepository applicationStatusRepository;
    private final ItemMapper itemMapper;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final AddressRepository addressRepository;
    private final Integer PROCESSING_STATUS_ID = 1;

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
    public void saveApplication(Integer customerId, AddressDto loadAddressDro, AddressDto unloadAddressDro, ItemDto... itemDtos) {
        List<Item> items = new ArrayList<>();
        for (ItemDto itemDto : itemDtos) {
            items.add(itemMapper.toModel(itemDto));
        }

        Application application = Application.builder()
                .customer(userRepository.getReferenceById(customerId))
                .loadingAddress(addressMapper.toModel(loadAddressDro))
                .unloadingAddress(addressMapper.toModel(unloadAddressDro))
                .items(items)
                .status(applicationStatusRepository.getReferenceById(PROCESSING_STATUS_ID))
                .build();

        applicationRepository.save(application);
    }

    // NOT READY!
    @Override
    public void editApplication(Integer applicationId, AddressDto loadAddressDro, AddressDto unloadAddressDro, ItemDto... itemDtos) {
        Application application = applicationRepository.getReferenceById(applicationId);
        Item item = itemRepository.getReferenceById(application.getItems().stream().findFirst().get().getId());
        item.setName(itemDtos[0].getName());
        item.setWeight(itemDtos[0].getWeight());
        item.setDimX(itemDtos[0].getDimX());
        item.setDimY(itemDtos[0].getDimY());
        item.setDimZ(itemDtos[0].getDimZ());
        List<Item> items = new ArrayList<>();
        items.add(item);
        Address loadingAddress = addressRepository.getReferenceById(application.getLoadingAddress().getId());
        loadingAddress.setCity(loadAddressDro.getCity());
        loadingAddress.setStreet(loadAddressDro.getStreet());
        loadingAddress.setBuilding(loadAddressDro.getBuilding());
        Address unloadingAddress = addressRepository.getReferenceById(application.getUnloadingAddress().getId());
        unloadingAddress.setCity(unloadAddressDro.getCity());
        unloadingAddress.setStreet(unloadAddressDro.getStreet());
        unloadingAddress.setBuilding(unloadAddressDro.getBuilding());

        application.setItems(items);
        application.setLoadingAddress(loadingAddress);
        application.setUnloadingAddress(unloadingAddress);
        applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(Integer id) {
        applicationRepository.deleteById(id);
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
    public ApplicationDto getApplicationDto(Integer applicationId) {
        return applicationMapper.toDto(applicationRepository.getReferenceById(applicationId));
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
    public Integer countAllUnallocatedApplications() {
        return getAllUnallocatedApplications().size();
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
