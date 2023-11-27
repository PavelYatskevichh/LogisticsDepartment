package com.academy.logistics_department.controller;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import com.academy.logistics_department.service.ApplicationService;
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
@RequestMapping(value = "/customer/{customerId}")
public class CustomerController {
    private final ApplicationService applicationService;

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
}
