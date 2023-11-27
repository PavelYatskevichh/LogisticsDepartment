package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.VehicleDto;
import com.academy.logistics_department.mappers.VehicleMapper;
import com.academy.logistics_department.model.repository.VehicleRepository;
import com.academy.logistics_department.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(vehicleMapper::toDto).toList();
    }
}
