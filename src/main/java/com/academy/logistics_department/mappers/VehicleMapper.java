package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.VehicleDto;
import com.academy.logistics_department.model.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface VehicleMapper {
    VehicleDto toDto(Vehicle vehicle);
    Vehicle toModel(VehicleDto vehicleDto);
    void updateModel(VehicleDto vehicleDto, @MappingTarget Vehicle vehicle);
}
