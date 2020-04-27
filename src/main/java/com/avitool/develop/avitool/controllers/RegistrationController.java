package com.avitool.develop.avitool.controllers;

import com.avitool.develop.avitool.dto.RegistrationDto;
import com.avitool.develop.avitool.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    //    @Autowired
//    private LoginService loginService;
    @Autowired
    private RegistrationService registrationService;

//    @Autowired
//    private UserAgentService userAgentService;

    //    @PreAuthorize("permitAll()")
    @GetMapping("/registration")
    public String getRegPage(Authentication authentication, Model model) {
//        try {
//            Scanner scanner = new Scanner(new File("D:\\AppForAvitool\\src\\main\\resources\\htmlpage\\user_agents.txt"));
//            while (scanner.hasNextLine()) {
//                if (!scanner.nextLine().isEmpty()) {
//                    UserAgentDto userAgent = UserAgentDto.builder()
//                            .userAgentString(scanner.nextLine())
//                            .build();
//                    userAgentService.addUserAgent(userAgent);
//                }
//            }
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
        if (authentication != null) {
            return "redirect:/";
        } else {
            model.addAttribute("user", new RegistrationDto());
            return "registration_page";
        }
    }

    //    @PreAuthorize("permitAll()")
    @PostMapping("/registration")
    public String sendDataRegPage(@Validated @ModelAttribute("user") RegistrationDto user,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
//            model.addAttribute()
            return "registration_page";
        } else {
            System.out.println(user.getLogin());
            System.out.println(user.getPassword());
            registrationService.registration(user);
            return "redirect:/login";
        }
    }
}
