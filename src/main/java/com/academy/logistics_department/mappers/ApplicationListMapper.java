package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.AddressDto;
import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.model.entity.Address;
import com.academy.logistics_department.model.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = ApplicationMapper.class)
public interface ApplicationListMapper {
    List<Application> toModelList(List<ApplicationDto> applicationDtoList);
    List<ApplicationDto> toDtoList(List<Application> applications);
}
