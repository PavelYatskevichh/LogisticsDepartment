package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.Route;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.enums.RouteStatusEnum;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = ApplicationListMapper.class)
@RequiredArgsConstructor
public abstract class RouteMapper {
    public static final RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);
    @Mapping(target = "status", expression = "java(defineStatus(route))")
    public abstract RouteDto toDto(Route route);
    public abstract Route toModel(RouteDto routeDto);

    public RouteStatusEnum defineStatus(Route route) {
        List<Application> applications = route.getApplications();

        if (applications.stream().allMatch(a -> a.getStatus().getStatusName().equals(ApplicationStatusEnum.DELIVERED))) {
            return RouteStatusEnum.COMPLETED;
        } else {
            return RouteStatusEnum.CURRENT;
        }
    }
}
