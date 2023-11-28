package com.academy.logistics_department.controller;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.DriverDto;
import com.academy.logistics_department.dto.RouteDto;
import com.academy.logistics_department.dto.VehicleDto;
import com.academy.logistics_department.service.ApplicationService;
import com.academy.logistics_department.service.RouteService;
import com.academy.logistics_department.service.UserService;
import com.academy.logistics_department.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/manager/{managerId}")
public class ManagerController {
    private final ApplicationService applicationService;
    private final RouteService routeService;
    private final VehicleService vehicleService;
    private final UserService userService;

    @GetMapping(value = "/main")
    public String getMain(@PathVariable Integer managerId, Model model) {
        List<RouteDto> activeRoutesDto = routeService.getAllActiveRoutes();
        model.addAttribute("activeRoutes", activeRoutesDto);

        Integer numberOfUnallocated = applicationService.countAllUnallocatedApplications();
        model.addAttribute("numberOfUnallocated", numberOfUnallocated);

        return "manager/main";
    }

    @GetMapping(value = "/unallocated")
    public String getUnallocated(@PathVariable Integer managerId, Model model) {
        List<ApplicationDto> unallocatedApplicationDtoList = applicationService.getAllUnallocatedApplications();
        model.addAttribute("unallocatedApplications", unallocatedApplicationDtoList);

        return "manager/unallocated";
    }

    @GetMapping(value = "/routes")
    public String getRoutes(@PathVariable Integer managerId, Model model) {
        List<RouteDto> activeRoutesDto = routeService.getAllActiveRoutes();
        model.addAttribute("activeRoutes", activeRoutesDto);

        List<RouteDto> completedRoutesDto = routeService.getAllCompletedRoutes();
        model.addAttribute("completedRoutes", completedRoutesDto);

        return "manager/routes";
    }

    @GetMapping(value = "/route")
    public String getRoute(@PathVariable Integer managerId, @RequestParam Integer id, Model model) {
        RouteDto routeDto = routeService.getRouteById(id);
        model.addAttribute("route", routeDto);

        List<ApplicationDto> activeApplicationsDto = applicationService.getAllActiveDriversApplications(routeDto);
        model.addAttribute("activeApplications", activeApplicationsDto);

        List<ApplicationDto> deliveredApplicationsDto = applicationService.getAllDeliveredDriversApplications(routeDto);
        model.addAttribute("deliveredApplications", deliveredApplicationsDto);

        model.addAttribute("managerId", managerId);

        return "manager/route";
    }

    @GetMapping(value = "/transport")
    public String getTransport(@PathVariable Integer managerId, Model model) {
        List<VehicleDto> vehicleDtoList = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicleDtoList);

        return "manager/transport";
    }

    @GetMapping(value = "/drivers")
    public String getDrivers(@PathVariable Integer managerId, Model model) {
        List<DriverDto> driverDtoList = userService.getAllDrivers();
        model.addAttribute("drivers", driverDtoList);

        return "manager/drivers";
    }
}
