package com.avitool.develop.avitool.service.google;

import com.avitool.develop.avitool.dto.AddAccountDto;

public interface GoogleAviToolAccountSheetRequestService {
    void sendToAccountSheet(AddAccountDto accountDto);
}
