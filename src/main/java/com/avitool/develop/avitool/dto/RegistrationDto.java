package com.avitool.develop.avitool.dto;

import com.avitool.develop.avitool.annotations.CheckKey;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegistrationDto {
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 5, message = "Логин должен быть не менее 5 символов")
    private String login;
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 5, message = "Пароль от 5 символов")
    private String password;
    @NotBlank(message = "Поле не может быть пустым")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я'][a-zA-Zа-яА-Я-' ]+[a-zA-Zа-яА-Я']?$",
            message = "Некорректное имя. Если имя содержит букву \"ё\", то измените ее на \"е\"")
    private String name;
    @NotBlank(message = "Поле не может быть пустым")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я'][a-zA-Zа-яА-Я-' ]+[a-zA-Zа-яА-Я']?$",
            message = "Некорректная фамилия. Если фамилия содержит букву(ы) \"ё\", то измените ее(их) на \"е\"")
    private String secondName;
    @CheckKey
    @NotBlank(message = "Поле не может быть пустым")
    private String key;
}
