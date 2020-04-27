package com.avitool.develop.avitool.service;

import com.avitool.develop.avitool.converter.UserDtoToUserConverter;
import com.avitool.develop.avitool.dto.AddAccountDto;
import com.avitool.develop.avitool.dto.AviToolAccountDto;
import com.avitool.develop.avitool.models.AviToolAccount;
import com.avitool.develop.avitool.repositories.AviToolAccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AviToolAccountServiceImpl implements AviToolAccountService {
    private static Logger logger = Logger.getLogger(AviToolAccountServiceImpl.class.getSimpleName());
    @Autowired
    private AviToolAccountRepository accountRepository;

    @Override
    public AviToolAccountDto addAccount(AddAccountDto accountData) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss zzz");
        UserDtoToUserConverter userDtoToUserConverter = new UserDtoToUserConverter();
        AviToolAccount account = AviToolAccount.builder()
                .login(accountData.getLogin())
                .password(accountData.getPassword())
                .phoneNumber(accountData.getPhoneNumber())
                .name(accountData.getName())
                .companyName(accountData.getCompanyName())
                .userAgent(accountData.getUserAgent())
                .proxy(accountData.getProxy())
                .comment(accountData.getComment())
                .reversoPhoneNumber(accountData.getReversoPhoneNumber())
                .createDate(simpleDateFormat.format(date))
                .creator(userDtoToUserConverter.convert(accountData.getCreator()))
                .build();
        AviToolAccount acc = accountRepository.save(account);
        logger.info("Create account with id: " + acc.getId());
        return AviToolAccountDto.from(account);
    }
}
