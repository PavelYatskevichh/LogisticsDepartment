package com.academy.logistics_department.controller;

import com.academy.logistics_department.model.entity.User;
import com.academy.logistics_department.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserRepository userRepository;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login/login";
    }

    @GetMapping("/redirect")
    public String redirectToUserSpecificPage(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Optional<User> userOptional = userRepository.findByEmailAddress(username);
            if (userOptional.isPresent()) {
                Integer userId = userOptional.get().getId();
                String role = userOptional.get().getRole().getRoleName().toString().toLowerCase();
                String userSpecificUrl = constructUserSpecificUrl(role, userId);
                return "redirect:" + userSpecificUrl;
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/";
        }
    }

    private String constructUserSpecificUrl(String role, Integer userId) {
        if (userId != null && role != null) {
            return "/" + role + "/" + userId + "/main";
        } else {
            return "/";
        }
    }
}
