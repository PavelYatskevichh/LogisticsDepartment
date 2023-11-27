package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.UserDto;
import com.academy.logistics_department.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper {
    UserDto toDto(User user);
    @Mapping(target = "password", ignore = true)
    User toModel(UserDto userDto);
    @Mapping(target = "password", ignore = true)
    void updateModel(UserDto userDto, @MappingTarget User user);
}
