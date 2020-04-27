package com.avitool.develop.avitool.converter;

import com.avitool.develop.avitool.dto.UserDto;
import com.avitool.develop.avitool.models.User;
import org.springframework.core.convert.converter.Converter;

public class UserToUserDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getName())
                .secondName(user.getSecondName())
                .build();
    }
}
