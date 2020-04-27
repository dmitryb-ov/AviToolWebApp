package com.avitool.develop.avitool.service.generators;

import com.avitool.develop.avitool.exceptions.InDataBaseNotFoundException;
import com.avitool.develop.avitool.models.UserAgent;
import com.avitool.develop.avitool.service.UserAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

@Component
public class UserAgentGeneratorImpl implements UserAgentGenerator {
    @Autowired
    private UserAgentService userAgentService;

    @Override
    public UserAgent generate() {
        try {
            Random random = new Random();
            Long countRows = userAgentService.getCountRows();
            int randomIntId = random.nextInt(countRows.intValue());
            Optional<UserAgent> userAgent = userAgentService.getUserAgentById((long) randomIntId);
            if (userAgent.isPresent()) {
                return userAgent.get();
            } else {
                throw new InDataBaseNotFoundException("В базе не найдено строки с id " + randomIntId);
            }
        } catch (InDataBaseNotFoundException e) {
            e.getMessage();
        }
        return null;
    }
}
