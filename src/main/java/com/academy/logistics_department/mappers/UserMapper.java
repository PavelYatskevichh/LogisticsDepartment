package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.UserDto;
import com.academy.logistics_department.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toDto(User user);
}
