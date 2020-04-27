package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.dto.AddAdsDto;
import com.avitool.develop.avitool.dto.AviToolAdsDto;

public interface AviToolAdsService {
    AviToolAdsDto addAds(AddAdsDto adsDto);
}
