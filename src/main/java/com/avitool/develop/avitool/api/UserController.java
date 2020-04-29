package com.avitool.develop.avitool.api;

import com.avitool.develop.avitool.dto.RegistrationDto;
import com.avitool.develop.avitool.dto.UserDto;
import com.avitool.develop.avitool.dto.api.ResponseUserDto;
import com.avitool.develop.avitool.dto.api.ResponseUsersDto;
import com.avitool.develop.avitool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseUserDto addUser(@RequestBody RegistrationDto userData) {
        return ResponseUserDto.builder()
                .data(userService.addUser(userData))
                .build();
    }

    @GetMapping("/users")
    public ResponseUsersDto getUsers() {
        return ResponseUsersDto.builder()
                .data(userService.getAllUsers())
                .build();
    }

    @GetMapping("/users/{user-id}")
    public ResponseUserDto getUser(@PathVariable("user-id") Long userId) {
        return ResponseUserDto.builder()
                .data(userService.getUser(userId))
                .build();
    }

//    @PostMapping("/user/auth/{user-login}")
//    public ResponseUserDto getUser(@PathVariable("user-login") String login, HttpServletRequest request){
//        Optional<User> user = userService.getUserByLogin(login);
//        if(user.isPresent()) {
//            request.getSession().setAttribute("login", login);
//            request.getSession().setAttribute("id",user.get().getId());
//            request.getSession().setAttribute("name", user.get().getName());
//            request.getSession().setAttribute("secondName",user.get().getSecondName());
//            request.getSession().setAttribute("role",user.get().getRole());
//        }
//        return ResponseUserDto.builder()
//                .data(userService.getApiUserByLogin(login))
//                .build();
//
//    }

    @PostMapping("/user/auth")
    public ResponseEntity<?> getUserAjax(@RequestBody UserDto userDto) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
        UserDto user = userService.getApiUserByLogin(userDto.getLogin());
        responseUserDto.setData(user);
        return ResponseEntity.ok(responseUserDto);
    }

    @PostMapping("/user/reg")
    public ResponseEntity<?> sendUserAjax(@RequestBody RegistrationDto userDto) {
        UserDto u = userService.addUser(userDto);
        return ResponseEntity.ok(u);
    }


}
