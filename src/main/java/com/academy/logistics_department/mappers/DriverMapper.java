package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.DriverDto;
import com.academy.logistics_department.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, CategoryListMapper.class})
public interface DriverMapper {
    DriverDto toDto(User user);
    @Mapping(target = "password", ignore = true)
    User toModel(DriverDto driverDto);
    @Mapping(target = "password", ignore = true)
    void updateModel(DriverDto driverDto, @MappingTarget User user);
}
