package com.avitool.develop.avitool.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "avi_ads")
public class AviToolAds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
