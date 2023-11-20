package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.DriverDto;
import com.academy.logistics_department.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);
    DriverDto toDto(User user);
}
