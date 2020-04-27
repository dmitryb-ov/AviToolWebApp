package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.dto.UserAgentDto;
import com.avitool.develop.avitool.models.UserAgent;
import com.avitool.develop.avitool.repositories.UserAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAgentServiceImpl implements UserAgentService {
    @Autowired
    private UserAgentRepository userAgentRepository;

    @Override
    public Optional<UserAgent> getUserAgentById(Long id) {

        return userAgentRepository.findUserAgentById(id);
    }

    @Override
    public void addUserAgent(UserAgentDto userAgentDto) {
        UserAgent userAgent = UserAgent.builder()
                .userAgentString(userAgentDto.getUserAgentString())
                .build();
        userAgentRepository.save(userAgent);
    }

    @Override
    public void deleteUserAgent(Long id) {
        userAgentRepository.deleteById(id);
    }

    @Override
    public Long getCountRows() {
        return userAgentRepository.count();
    }
}
