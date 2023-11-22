package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.ApplicationStatusDto;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ApplicationStatusMapper {
    ApplicationStatusDto toDto(ApplicationStatus applicationStatus);
    ApplicationStatus toModel(ApplicationStatusDto applicationStatusDto);
    void updateModel(ApplicationStatusDto applicationStatusDto, @MappingTarget ApplicationStatus applicationStatus);
}
