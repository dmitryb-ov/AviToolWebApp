package com.avitool.develop.avitool.service.google;

import com.avitool.develop.avitool.dto.AddAdsDto;

public interface GoogleAviToolAdsSheetRequestService {
    void sendToAdsSheet(AddAdsDto adsDto);
}
