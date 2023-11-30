package com.academy.logistics_department.controller;

import com.academy.logistics_department.dto.AddressDto;
import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.ItemDto;
import com.academy.logistics_department.model.entity.User;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.repository.UserRepository;
import com.academy.logistics_department.service.AddressService;
import com.academy.logistics_department.service.ApplicationService;
import com.academy.logistics_department.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/customer/{customerId}")
public class CustomerController {
    private final ApplicationService applicationService;
    private final ItemService itemService;
    private final AddressService addressService;
    private final UserRepository userRepository;

    @GetMapping(value = "/main")
    public String getMain(@PathVariable Integer customerId, Model model) {
        List<ApplicationDto> activeApplicationsDto = applicationService.getAllActiveCustomersApplications(customerId);
        model.addAttribute("activeApplications", activeApplicationsDto);

        List<ApplicationDto> deliveredApplicationsDto = applicationService.getAllDeliveredCustomersApplications(customerId);
        model.addAttribute("deliveredApplications", deliveredApplicationsDto);

        model.addAttribute("customerId", customerId);

        return "customer/main";
    }

    @GetMapping(value = "/application")
    public String getApplication(@PathVariable Integer customerId, @RequestParam Integer id, Model model) {
        ApplicationDto applicationDto = applicationService.getCustomersApplicationDto(customerId, id);
        model.addAttribute("application", applicationDto);

        model.addAttribute("customerId", customerId);
        model.addAttribute("DELIVERED", ApplicationStatusEnum.DELIVERED);

        return "customer/application";
    }

    @GetMapping(value = "/showCreateApplication")
    public String showCreateApplication(@PathVariable Integer customerId) {

        return "customer/createApplication";
    }

    @PostMapping(value = "/createApplication")
    public String createApplication(@PathVariable Integer customerId,
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

        applicationService.saveApplication(customerId, loadAddressDto, unloadAddressDto, itemDto1);

        return "redirect:main";
    }

    @GetMapping(value = "/authorization")
    public String getAuthorization(@PathVariable Integer customerId, Model model) {
        User user = userRepository.getReferenceById(customerId);
        model.addAttribute("user", user);

        return "customer/authorization";
    }
}
