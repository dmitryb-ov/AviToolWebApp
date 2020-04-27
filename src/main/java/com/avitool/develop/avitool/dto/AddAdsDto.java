package com.avitool.develop.avitool.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class AddAdsDto {
    @NotBlank
    private Long accountId;
    @NotBlank
    private String accountLogin;
    @NotBlank
    private String city;
    @NotBlank
    private String category;
    @NotBlank
    private String accountPhoneNumber;
    @NotBlank
    private String accountName;
    @NotBlank
    private String header;
    @NotBlank
    private String text;
    @NotBlank
    private int price;
    @NotBlank
    private String imgPath;
    private String URLAds;
    private String comment;
    private String date;
    private String allViews;
    private String todayViews;
}
