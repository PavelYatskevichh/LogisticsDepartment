package com.academy.logistics_department.controller;

import com.academy.logistics_department.dto.AddressDto;
import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.ItemDto;
import com.academy.logistics_department.mappers.AddressMapper;
import com.academy.logistics_department.mappers.ItemMapper;
import com.academy.logistics_department.mappers.UserMapper;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.model.repository.AddressRepository;
import com.academy.logistics_department.model.repository.ItemRepository;
import com.academy.logistics_department.model.repository.UserRepository;
import com.academy.logistics_department.service.AddressService;
import com.academy.logistics_department.service.ApplicationService;
import com.academy.logistics_department.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/customer/{customerId}")
public class CustomerController {
    private final ApplicationService applicationService;
    private final ItemService itemService;
    private final AddressService addressService;
    private final ItemRepository itemRepository;
    private final AddressRepository addressRepository;
    private final ItemMapper itemMapper;
    private final AddressMapper addressMapper;

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
    public String showCreateApplication(@PathVariable Integer customerId, Model model) {
        model.addAttribute("createItem", new ItemDto());
        model.addAttribute("createLoadAddress", new AddressDto());
        model.addAttribute("createUnloadAddress", new AddressDto());

        return "customer/createApplication";
    }

    @PostMapping(value = "/createApplication")
    public String createApplication(@PathVariable Integer customerId,
                                    @ModelAttribute("createLoadAddress") AddressDto loadAddressDto,
                                    @ModelAttribute("createUnloadAddress") AddressDto unloadAddressDto,
                                    @ModelAttribute("createItem") ItemDto itemDto) {

        applicationService.saveApplication(customerId, loadAddressDto, unloadAddressDto, itemDto);

        return "redirect:main";
    }
}
