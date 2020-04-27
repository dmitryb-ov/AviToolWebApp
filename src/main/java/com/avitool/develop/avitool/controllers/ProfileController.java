package com.avitool.develop.avitool.controllers;

import com.avitool.develop.avitool.converter.UserToUserDtoConverter;
import com.avitool.develop.avitool.security.jwt.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getPage(Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        UserToUserDtoConverter userToUserDtoConverter = new UserToUserDtoConverter();
        model.addAttribute("myuser", userToUserDtoConverter.convert(userDetails.getUser()));
        return "profile_page";
    }
}
