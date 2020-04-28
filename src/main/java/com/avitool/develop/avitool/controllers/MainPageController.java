package com.avitool.develop.avitool.controllers;

import com.avitool.develop.avitool.dto.AddAccountDto;
import com.avitool.develop.avitool.dto.AddAdsDto;
import com.avitool.develop.avitool.dto.AviToolAccountDto;
import com.avitool.develop.avitool.dto.UserDto;
import com.avitool.develop.avitool.security.jwt.details.UserDetailsImpl;
import com.avitool.develop.avitool.service.AviToolAccountService;
import com.avitool.develop.avitool.service.AviToolAdsService;
import com.avitool.develop.avitool.service.generators.LoginGenerator;
import com.avitool.develop.avitool.service.generators.UserAgentGenerator;
import com.avitool.develop.avitool.service.google.GoogleAviToolAccountSheetRequestService;
import com.avitool.develop.avitool.service.google.GoogleAviToolAdsSheetRequestService;
import com.avitool.develop.avitool.service.sms.SmsActivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@Controller
public class MainPageController {
    @Autowired
    private LoginGenerator loginGenerator;

    @Autowired
    private UserAgentGenerator userAgentGenerator;

    @Autowired
    private AviToolAccountService aviToolAccountService;

    @Autowired
    private AviToolAdsService aviToolAdsService;

    @Autowired
    private GoogleAviToolAccountSheetRequestService accountSheetsRequestService;

    @Autowired
    private GoogleAviToolAdsSheetRequestService aviToolAdsSheetService;

    @Autowired
    private SmsActivateService smsActivateService;


    //    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public String getMainPage(Authentication authentication, Model model) {
        if (authentication != null) {
            AddAccountDto accountDto = new AddAccountDto();
            accountDto.setLogin(loginGenerator.generate());
            accountDto.setPassword("MyPassw01");
            accountDto.setName("Никита");
//            accountDto.setUserAgent(userAgentGenerator.generate().getUserAgentString());
            accountDto.setReversoPhoneNumber("89872659298");
//            accountDto.setReversoPhoneNumber("");

            model.addAttribute("account", accountDto);
            return "new_main_page";
        } else {
            return "login_page";
        }
    }

    @PostMapping("/")
    public String sendAccount(@Validated @ModelAttribute("account") AddAccountDto accountDto, BindingResult result, Authentication authentication) {
        if (result.hasErrors()) {
            return "new_main_page";
        } else {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            UserDto userDto = UserDto.builder()
                    .id(userDetails.getUser().getId())
                    .login(userDetails.getUsername())
                    .build();
            accountDto.setCreator(userDto);
            AviToolAccountDto aviToolAccountDto = aviToolAccountService.addAccount(accountDto);
            accountSheetsRequestService.sendToAccountSheet(accountDto);

            if (aviToolAccountDto != null) {
                aviToolAdsService.addAds(AddAdsDto.builder()
                        .accountId(aviToolAccountDto.getId())
                        .accountLogin(aviToolAccountDto.getLogin())
                        .city("a")
                        .category("a")
                        .accountPhoneNumber(aviToolAccountDto.getPhoneNumber())
                        .accountName(aviToolAccountDto.getName())
                        .header("Репетитор")
                        .text("ff")
                        .price(2000)
                        .imgPath("ss")
                        .comment("d")
                        .build());
                aviToolAdsSheetService.sendToAdsSheet(AddAdsDto.builder()
                        .accountId(aviToolAccountDto.getId())
                        .accountName(aviToolAccountDto.getLogin())
                        .city("city")
                        .category("catgory")
                        .accountPhoneNumber(aviToolAccountDto.getPhoneNumber())
                        .accountName(aviToolAccountDto.getName())
                        .header("gg")
                        .text("ff")
                        .price(2000)
                        .imgPath("ff")
                        .URLAds("")
                        .comment("")
                        .build());
            }
            return "redirect:/";
        }
    }

    @GetMapping("/getApiAviCount")
    public @ResponseBody
    String getApiCount() {
        return smsActivateService.getNumberCount();
    }

    @GetMapping("/getApiAviBalance")
    public @ResponseBody
    String getApiBalance() {
        return smsActivateService.getBalance();
    }
}
