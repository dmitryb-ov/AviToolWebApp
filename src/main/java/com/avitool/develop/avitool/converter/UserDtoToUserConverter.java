package com.avitool.develop.avitool.converter;

import com.avitool.develop.avitool.dto.UserDto;
import com.avitool.develop.avitool.models.User;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToUserConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .name(userDto.getName())
                .secondName(userDto.getSecondName())
                .build();
    }
}
