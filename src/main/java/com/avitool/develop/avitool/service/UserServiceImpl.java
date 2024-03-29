package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.dto.RegistrationDto;
import com.avitool.develop.avitool.dto.UserDto;
import com.avitool.develop.avitool.models.Role;
import com.avitool.develop.avitool.models.User;
import com.avitool.develop.avitool.repositories.UsersRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class.getSimpleName());
    @Autowired
    private UsersRepository usersRepository;


    @Override
    public List<UserDto> getAllUsers() {
        logger.info("Get all users");
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    public void deleteUser(Long userId) {
        logger.info("Delete user by id: " + userId);
        usersRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        logger.info("Get user by login " + login);
        return usersRepository.findUserByLogin(login);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        logger.info("Get user by id: " + userId);
        return usersRepository.findUserById(userId);
    }

    @Override
    public User changeUser(User user) {
        logger.info("Change user by id: " + user.getId());
        return usersRepository.save(user);
    }

    @Override
    public UserDto addUser(RegistrationDto registrationDto) {
        User user = User.builder()
                .login(registrationDto.getLogin())
                .password(registrationDto.getPassword())
                .name(registrationDto.getName())
                .secondName(registrationDto.getSecondName())
                .role(Role.USER)
                .build();
        usersRepository.save(user);
        return UserDto.from(user);
    }

    @Override
    public UserDto getUser(Long userId) {
        return UserDto.from(usersRepository.getOne(userId));
    }

    @Override
    public UserDto getApiUserByLogin(String login) {
        if (usersRepository.findUserByLogin(login).isPresent()) {
            return UserDto.from(usersRepository.findUserByLogin(login).get());
        } else {
            return UserDto.builder()
                    .login("null")
                    .name("null")
                    .secondName("null")
                    .build();
        }
    }
}
