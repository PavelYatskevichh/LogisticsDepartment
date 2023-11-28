package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.ItemDto;
import com.academy.logistics_department.mappers.ItemMapper;
import com.academy.logistics_department.model.entity.Item;
import com.academy.logistics_department.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;

    @Override
    public ItemDto createItem(String name, Integer dimX, Integer dimY, Integer dimZ, Integer weight) {
        Item item = Item.builder()
                .name(name)
                .dimX(dimX)
                .dimY(dimY)
                .dimZ(dimZ)
                .weight(weight)
                .build();

        return itemMapper.toDto(item);
    }
}
