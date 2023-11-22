package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.AddressDto;
import com.academy.logistics_department.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toDto(Address user);
    Address toModel(AddressDto userDto);
    void updateModel(AddressDto addressDto, @MappingTarget Address address);
}
