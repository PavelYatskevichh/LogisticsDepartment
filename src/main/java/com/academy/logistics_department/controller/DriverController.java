package com.academy.logistics_department.controller;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.dto.UserDto;
import com.academy.logistics_department.mappers.UserMapper;
import com.academy.logistics_department.model.entity.User;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.repository.UserRepository;
import com.academy.logistics_department.service.ApplicationService;
import com.academy.logistics_department.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/driver/{driverId}")
public class DriverController {
    private final RouteService routeService;
    private final ApplicationService applicationService;

    @GetMapping(value = "/main")
    public String getMain(@PathVariable Integer driverId, Model model) {
        RouteDto currentRouteDto = routeService.getDriversCurrentRoute(driverId);
        model.addAttribute("currentRoute", currentRouteDto);

        List<RouteDto> completedRoutesDto = routeService.getDriversAllCompletedRoutes(driverId);
        model.addAttribute("completedRoutes", completedRoutesDto);

        model.addAttribute("driverId", driverId);

        return "driver/main";
    }

    @GetMapping(value = "/route")
    public String getRoute(@PathVariable Integer driverId, @RequestParam Integer id, Model model) {
        RouteDto routeDto = routeService.getRouteById(driverId, id);
        model.addAttribute("route", routeDto);

        List<ApplicationDto> activeApplicationsDto = applicationService.getAllActiveDriversApplications(routeDto);
        model.addAttribute("activeApplications", activeApplicationsDto);

        List<ApplicationDto> deliveredApplicationsDto = applicationService.getAllDeliveredDriversApplications(routeDto);
        model.addAttribute("deliveredApplications", deliveredApplicationsDto);

        model.addAttribute("driverId", driverId);

        return "driver/route";
    }

    @GetMapping(value = "/current")
    public String getCurrent(@PathVariable Integer driverId, Model model) {
        RouteDto routeDto = routeService.getDriversCurrentRoute(driverId);
        model.addAttribute("route", routeDto);

        List<ApplicationDto> activeApplicationsDto = applicationService.getAllActiveDriversApplications(routeDto);
        model.addAttribute("activeApplications", activeApplicationsDto);

        List<ApplicationDto> deliveredApplicationsDto = applicationService.getAllDeliveredDriversApplications(routeDto);
        model.addAttribute("deliveredApplications", deliveredApplicationsDto);

        model.addAttribute("driverId", driverId);

        return "driver/route";
    }

    //NOT READY!!!
    @GetMapping(value = "/route/changeStatus")
    @ResponseBody
    public String changeStatus(@PathVariable Integer driverId,
                               @RequestParam Integer routeId,
                               @RequestParam Integer applicationId) {
        RouteDto routeDto = routeService.getRouteById(driverId, routeId);
        ApplicationStatusEnum applicationStatusEnum = applicationService.changeApplicationStatus(routeDto, applicationId);

        return applicationStatusEnum.name();
    }
}
