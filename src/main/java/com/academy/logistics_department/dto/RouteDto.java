package com.academy.logistics_department.dto;

import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.User;
import com.academy.logistics_department.model.entity.Vehicle;
import com.academy.logistics_department.model.enums.RouteStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {
    private Integer id;
    private List<ApplicationDto> applications;
    private User driver;
    private Vehicle vehicle;
    private User manager;
    private RouteStatusEnum status;
}
