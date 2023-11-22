package com.academy.logistics_department.dto;

import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationStatusDto {
    private Integer id;
    private ApplicationStatusEnum statusName;
}
