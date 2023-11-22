package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.ItemDto;
import com.academy.logistics_department.model.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface ItemListMapper {
    List<Item> toModelList(List<ItemDto> itemDtoList);
    List<ItemDto> toDtoList(List<Item> items);
}
