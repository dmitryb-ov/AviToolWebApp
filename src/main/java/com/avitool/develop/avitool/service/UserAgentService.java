package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.dto.UserAgentDto;
import com.avitool.develop.avitool.models.UserAgent;

import java.util.Optional;

public interface UserAgentService {
    Optional<UserAgent> getUserAgentById(Long id);

    void addUserAgent(UserAgentDto userAgent);

    void deleteUserAgent(Long id);

    Long getCountRows();
}
