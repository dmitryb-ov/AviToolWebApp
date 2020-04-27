package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.dto.AddAccountDto;
import com.avitool.develop.avitool.dto.AviToolAccountDto;

public interface AviToolAccountService {
    AviToolAccountDto addAccount(AddAccountDto accountDto);
}
