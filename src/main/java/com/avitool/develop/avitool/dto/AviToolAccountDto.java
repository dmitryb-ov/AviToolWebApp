package com.avitool.develop.avitool.dto;

import com.avitool.develop.avitool.models.AviToolAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AviToolAccountDto {
    private Long id;
    private String login;
    private String password;
    private String phoneNumber;
    private String name;
    private String companyName;
    private String userAgent;
    private String proxy;
    private String comment;
    private String reversoPhoneNumber;
    private String createDate;
    private UserDto creatorId;

    public static AviToolAccountDto from(AviToolAccount account) {
        return AviToolAccountDto.builder()
                .id(account.getId())
                .login(account.getLogin())
                .password(account.getPassword())
                .phoneNumber(account.getPhoneNumber())
                .name(account.getName())
                .companyName(account.getCompanyName())
                .userAgent(account.getUserAgent())
                .proxy(account.getProxy())
                .comment(account.getComment())
                .reversoPhoneNumber(account.getReversoPhoneNumber())
                .createDate(account.getCreateDate())
                .build();
    }
}
