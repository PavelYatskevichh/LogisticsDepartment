package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.model.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);
    ApplicationDto toDto(Application application);
    Application toModel(ApplicationDto applicationDto);
    void updateApplication(ApplicationDto applicationDto, @MappingTarget Application application);
}
