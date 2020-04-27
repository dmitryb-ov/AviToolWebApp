package com.avitool.develop.avitool.dto;

import com.avitool.develop.avitool.annotations.CheckPhoneNumber;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class AddAccountDto {
    @NotBlank(message = "Логин не может быть пустым")
    private String login;
    @NotBlank(message = "Поле пароль не может быть пустым")
    @Size(min = 6, max = 24, message = "Длина пароля от 6 до 24 символов")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\s\\w]).{6,}",
            message = "Пароль должен содержать буквы верхнего и нижнего регистра," +
                    " цифры")
    private String password;
    @NotBlank(message = "Поле номер теелефона не может быть пустым")
    @CheckPhoneNumber(message = "Некорректный номер телефона. Пример корректного: 79604567777")
    private String phoneNumber;
    @NotBlank(message = "Поле имя не может быть пустым")
    @Pattern(regexp = "[А-Яа-я]+$", message = "Имя только на русском, без спец символов и цифр")
    private String name;

    private String companyName;

    private String userAgent;

    private String proxy;

    private String comment;
    @NotBlank(message = "Номер переадресации не может быть пустым")
    @CheckPhoneNumber(message = "Некорректный номер телефона. Пример корректного: 79604567777")
    private String reversoPhoneNumber;

    private UserDto creator;
}
