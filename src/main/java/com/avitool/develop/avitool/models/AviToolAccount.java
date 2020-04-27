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
@Table(name = "avi_accounts")
public class AviToolAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id")
    private User creator;
}
