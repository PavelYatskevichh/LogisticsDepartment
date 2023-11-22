package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.model.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ItemListMapper.class, AddressMapper.class, UserMapper.class, ApplicationStatusMapper.class})
public interface ApplicationMapper {
    ApplicationDto toDto(Application application);
    Application toModel(ApplicationDto applicationDto);
    void updateModel(ApplicationDto applicationDto, @MappingTarget Application application);
}
