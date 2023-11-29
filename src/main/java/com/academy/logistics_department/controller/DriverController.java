package com.academy.logistics_department.controller;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.service.ApplicationService;
import com.academy.logistics_department.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/driver/{driverId}")
public class DriverController {
    private final RouteService routeService;
    private final ApplicationService applicationService;

    @GetMapping(value = "/main")
    public String getMain(@PathVariable Integer driverId, Model model) {
        List<RouteDto> currentRoutesDto = routeService.getDriversCurrentRoutes(driverId);
        model.addAttribute("currentRoutes", currentRoutesDto);

        List<RouteDto> completedRoutesDto = routeService.getAllDriversCompletedRoutes(driverId);
        model.addAttribute("completedRoutes", completedRoutesDto);

        model.addAttribute("driverId", driverId);

        return "driver/main";
    }

    @GetMapping(value = "/route")
    public String getRoute(@PathVariable Integer driverId, @RequestParam Integer id, Model model) {
        List<RouteDto> currentRoutesDto = routeService.getDriversCurrentRoutes(driverId);
        model.addAttribute("currentRoutes", currentRoutesDto);

        RouteDto routeDto = routeService.getDriversRouteById(driverId, id);
        model.addAttribute("route", routeDto);

        List<ApplicationDto> activeApplicationsDto = applicationService.getAllActiveDriversApplications(routeDto);
        model.addAttribute("activeApplications", activeApplicationsDto);

        List<ApplicationDto> deliveredApplicationsDto = applicationService.getAllDeliveredDriversApplications(routeDto);
        model.addAttribute("deliveredApplications", deliveredApplicationsDto);

        model.addAttribute("driverId", driverId);

        return "driver/route";
    }

    @GetMapping(value = "/route/changeStatus")
    @ResponseBody
    public String changeStatus(@PathVariable Integer driverId,
                               @RequestParam Integer routeId,
                               @RequestParam Integer applicationId) {
        RouteDto routeDto = routeService.getDriversRouteById(driverId, routeId);
        ApplicationStatusEnum applicationStatusEnum = applicationService.changeApplicationStatus(routeDto, applicationId);

        return applicationStatusEnum.name();
    }
}
