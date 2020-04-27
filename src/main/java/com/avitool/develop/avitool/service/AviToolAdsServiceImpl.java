package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.dto.AddAdsDto;
import com.avitool.develop.avitool.dto.AviToolAdsDto;
import com.avitool.develop.avitool.models.AviToolAds;
import com.avitool.develop.avitool.repositories.AviToolAdsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AviToolAdsServiceImpl implements AviToolAdsService {
    private static Logger logger = Logger.getLogger(AviToolAccountServiceImpl.class.getSimpleName());
    @Autowired
    private AviToolAdsRepository adsRepository;

    @Override
    public AviToolAdsDto addAds(AddAdsDto adsDto) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss zzz");
        AviToolAds aviToolAds = AviToolAds.builder()
                .accountId(adsDto.getAccountId())
                .accountLogin(adsDto.getAccountLogin())
                .city(adsDto.getCity())
                .category(adsDto.getCity())
                .accountPhoneNumber(adsDto.getAccountPhoneNumber())
                .accountName(adsDto.getAccountName())
                .header(adsDto.getHeader())
                .text(adsDto.getText())
                .price(adsDto.getPrice())
                .comment(adsDto.getComment())
                .createDate(simpleDateFormat.format(date))
                .build();
        AviToolAds ads = adsRepository.save(aviToolAds);
        logger.info("Add ads with id: " + ads.getId());
        return AviToolAdsDto.from(aviToolAds);
    }
}
