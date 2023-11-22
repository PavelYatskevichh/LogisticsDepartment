package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.DriverDto;
import com.academy.logistics_department.dto.ItemDto;
import com.academy.logistics_department.model.entity.Item;
import com.academy.logistics_department.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto toDto(Item item);
    Item toModel(ItemDto itemDto);
    void updateModel(ItemDto itemDto, @MappingTarget Item item);
}
