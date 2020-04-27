package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.dto.RegistrationDto;
import com.avitool.develop.avitool.models.Role;
import com.avitool.develop.avitool.models.User;
import com.avitool.develop.avitool.repositories.UsersRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegistrationServiceImpl implements RegistrationService {
    static Logger logger = Logger.getLogger(RegistrationServiceImpl.class.getName());

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void registration(RegistrationDto form) {
        User user = User.builder()
                .login(form.getLogin())
                .password(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .secondName(form.getSecondName())
                .role(Role.USER)
                .build();
        User successUser = usersRepository.save(user);
        logger.info("User with id: " + successUser.getId() + " successful signUp in system");
    }
}
