package com.avitool.develop.avitool.controllers.admin;

import com.avitool.develop.avitool.dto.UserDto;
import com.avitool.develop.avitool.models.Role;
import com.avitool.develop.avitool.models.User;
import com.avitool.develop.avitool.security.jwt.details.UserDetailsImpl;
import com.avitool.develop.avitool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminUsersController {
    private static final String GIVE_ADMIN = "Выдать роль администратора";
    private static final String GIVE_USER = "Выдать роль пользователя";
    private static final String DELETE_USER = "Удалить";
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin/users")
    public String getAdminUsersPage(Model model) {
        List<UserDto> users = userService.getAllUsers();

        model.addAttribute("users", users);
        return "admin_users_page";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/admin/users")
    public String sendAction(Authentication authentication, @RequestParam("user_id") String id, @RequestParam("select") String choose) {
        if (!choose.isEmpty()) {
            if (choose.equals(GIVE_ADMIN)) {
                Optional<User> user = userService.getUserById(Long.parseLong(id));
                if (user.isPresent()) {
                    User refreshUser = user.get();
                    refreshUser.setRole(Role.ADMIN);
                    userService.changeUser(refreshUser);
                }
            }
            if (choose.equals(GIVE_USER)) {
                Optional<User> user = userService.getUserById(Long.parseLong(id));
                if (user.isPresent()) {
                    User refreshUser = user.get();
                    refreshUser.setRole(Role.USER);
                    userService.changeUser(refreshUser);
                }
                return "redirect:/";
            }
            if (choose.equals(DELETE_USER)) {
                Optional<User> user = userService.getUserById(Long.parseLong(id));
                if (user.isPresent()) {
                    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
                    Long myUserId = userDetails.getUser().getId();
                    if (Long.parseLong(id) == myUserId) {
                        userService.deleteUser(Long.parseLong(id));
                        return "redirect:/";
                    }
                    userService.deleteUser(Long.parseLong(id));
                }
            }
        }
        return "redirect:/admin/users";
    }
}
