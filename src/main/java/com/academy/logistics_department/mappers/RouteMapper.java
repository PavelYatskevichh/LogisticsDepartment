package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.Route;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.enums.RouteStatusEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ApplicationListMapper.class, VehicleMapper.class, DriverMapper.class, UserMapper.class})
public interface RouteMapper {
    @Mapping(target = "status", expression = "java(defineStatus(route))")
    RouteDto toDto(Route route);
    Route toModel(RouteDto routeDto);
    void updateModel(RouteDto routeDto, @MappingTarget Route route);

    default RouteStatusEnum defineStatus(Route route) {
        List<Application> applications = route.getApplications();

        if (applications.stream().allMatch(a -> a.getStatus().getStatusName().equals(ApplicationStatusEnum.DELIVERED))) {
            return RouteStatusEnum.COMPLETED;
        } else if (applications.stream().noneMatch(a -> a.getStatus().getStatusName().equals(ApplicationStatusEnum.PROCESSING))) {
            return RouteStatusEnum.CURRENT;
        } else {
            return null;
        }
    }
}
