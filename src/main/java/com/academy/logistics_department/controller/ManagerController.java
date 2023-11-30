package com.academy.logistics_department.controller;

import com.academy.logistics_department.dto.*;
import com.academy.logistics_department.model.entity.User;
import com.academy.logistics_department.model.repository.UserRepository;
import com.academy.logistics_department.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/manager/{managerId}")
public class ManagerController {
    private final ApplicationService applicationService;
    private final RouteService routeService;
    private final VehicleService vehicleService;
    private final UserService userService;
    private final AddressService addressService;
    private final ItemService itemService;
    private final UserRepository userRepository;

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

    @GetMapping(value = "/showCreateRoute")
    public String showCreateRoute(@PathVariable Integer managerId) {

        return "manager/createRoute";
    }

    @PostMapping(value = "/createRoute")
    public String createRoute(@PathVariable Integer managerId,
                              @RequestParam Integer driverId,
                              @RequestParam Integer vehicleId,
                              @RequestParam("applicationId") Integer... applicationIds) {
        routeService.saveRoute(managerId, driverId, vehicleId, applicationIds);

        return "redirect:main";
    }

    @GetMapping(value = "/showEditApplication")
    public String showEditApplication(@PathVariable Integer managerId,
                                      @RequestParam Integer applicationId, Model model) {
        ApplicationDto applicationDto = applicationService.getApplicationDto(applicationId);
        model.addAttribute("application", applicationDto);

        model.addAttribute("managerId", managerId);

        return "manager/editApplication";
    }

    @PostMapping(value = "/editApplication")
    public String editApplication(@PathVariable Integer managerId,
                                  @RequestParam Integer applicationId,
                                  @RequestParam String name,
                                  @RequestParam Integer dimX,
                                  @RequestParam Integer dimY,
                                  @RequestParam Integer dimZ,
                                  @RequestParam Integer weight,
                                  @RequestParam String loadCity,
                                  @RequestParam String loadStreet,
                                  @RequestParam String loadBuilding,
                                  @RequestParam String unloadCity,
                                  @RequestParam String unloadStreet,
                                  @RequestParam String unloadBuilding) {
        AddressDto loadAddressDto = addressService.createAddress(loadCity, loadStreet, loadBuilding);
        AddressDto unloadAddressDto = addressService.createAddress(unloadCity, unloadStreet, unloadBuilding);
        ItemDto itemDto1 = itemService.createItem(name, dimX, dimY, dimZ, weight);

        applicationService.editApplication(applicationId, loadAddressDto, unloadAddressDto, itemDto1);

        return "redirect:unallocated";
    }

    @GetMapping(value = "/deleteApplication")
    public String deleteApplication(@PathVariable Integer managerId,
                                    @RequestParam Integer applicationId) {
        applicationService.deleteApplication(applicationId);

        return "redirect:unallocated";
    }

    @GetMapping(value = "/authorization")
    public String getAuthorization(@PathVariable Integer managerId, Model model) {
        User user = userRepository.getReferenceById(managerId);
        model.addAttribute("user", user);

        return "manager/authorization";
    }
}
