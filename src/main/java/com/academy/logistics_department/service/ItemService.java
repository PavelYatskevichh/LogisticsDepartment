package com.academy.logistics_department.service;

import com.academy.logistics_department.dto.ItemDto;
import com.academy.logistics_department.model.entity.Application;

public interface ItemService {
    ItemDto createItem(String name, Integer dimX, Integer dimY, Integer dimZ, Integer weight);
}
