package com.academy.logistics_department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Integer id;
    private String name;
    private Integer weight;
    private Integer dimX;
    private Integer dimY;
    private Integer dimZ;
}
