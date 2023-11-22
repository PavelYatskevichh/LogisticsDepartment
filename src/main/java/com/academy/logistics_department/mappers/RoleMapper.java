package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.RoleDto;
import com.academy.logistics_department.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto(Role role);
    Role toModel(RoleDto roleDto);
    void updateModel(RoleDto roleDto, @MappingTarget Role role);
}
