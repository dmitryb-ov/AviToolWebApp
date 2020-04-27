package com.avitool.develop.avitool.dto;

import com.avitool.develop.avitool.models.AviToolAds;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AviToolAdsDto {
    private Long id;
    private Long accountId;
    private String accountLogin;
    private String city;
    private String category;
    private String accountPhoneNumber;
    private String accountName;
    private String header;
    private String text;
    private int price;
    //    private String pathToImg;
//    private String URLAdv;
    private String comment;
    private String createDate;
//    private String date;
//    private String allViews;
//    private String viewsToday;

    public static AviToolAdsDto from(AviToolAds ads) {
        return AviToolAdsDto.builder()
                .id(ads.getId())
                .accountId(ads.getAccountId())
                .accountLogin(ads.getAccountLogin())
                .city(ads.getCity())
                .category(ads.getCategory())
                .accountPhoneNumber(ads.getAccountPhoneNumber())
                .accountName(ads.getAccountName())
                .header(ads.getHeader())
                .text(ads.getText())
                .price(ads.getPrice())
                .comment(ads.getComment())
                .createDate(ads.getCreateDate())
                .build();
    }

}
