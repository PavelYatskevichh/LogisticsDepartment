package com.academy.logistics_department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Integer id;
    private String name;
    private Integer maxLoadCapacity;
    private Integer maxTripDistance;
    private Integer dimXRestrictions;
    private Integer dimYRestrictions;
    private Integer dimZRestrictions;
    private CategoryDto requiredCategory;
}
