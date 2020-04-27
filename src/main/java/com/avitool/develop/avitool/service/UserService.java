package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.dto.UserDto;
import com.avitool.develop.avitool.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUsers();

    void deleteUser(Long userId);

    Optional<User> getUserByLogin(String login);

    Optional<User> getUserById(Long userId);

    User changeUser(User user);
}
