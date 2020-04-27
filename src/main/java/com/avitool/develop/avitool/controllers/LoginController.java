package com.avitool.develop.avitool.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    //    @PreAuthorize("permitAll()")
    @GetMapping("/login")
    public String getLoginPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/";
        }
        return "log_page";
    }
}
