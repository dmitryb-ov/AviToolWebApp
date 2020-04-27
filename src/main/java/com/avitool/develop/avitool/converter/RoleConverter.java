package com.avitool.develop.avitool.converter;

import com.avitool.develop.avitool.models.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

public class RoleConverter implements Converter<Role, String> {
    @Override
    public String convert(@NonNull Role role) {
        if (role == Role.ADMIN) {
            return "Администратор";
        }
        if (role == Role.USER) {
            return "Пользователь";
        }
        return role.toString();
    }
}
