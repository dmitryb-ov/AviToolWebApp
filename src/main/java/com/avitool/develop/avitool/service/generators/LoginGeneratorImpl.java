package com.avitool.develop.avitool.service.generators;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class LoginGeneratorImpl implements LoginGenerator {
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz1234567890_-".toCharArray();
    private static final int maxLengthOfEmail = 12;
    private static final int minLengthOfEmail = 5;
    private String[] mailType = {"@yandex.ru", "@mail.ru", "@inbox.ru", "@gmai.com", "@hotmail.com"};

    public String generate() {
        Random randomLength = new Random();
        int length = minLengthOfEmail + randomLength.nextInt(maxLengthOfEmail - minLengthOfEmail);
        StringBuilder myMail = new StringBuilder();
        for (int i = 0; i < length; i++) {
            Random randomLet = new Random();
            myMail.append(alphabet[randomLet.nextInt(alphabet.length)]);
        }
        Random randomMailType = new Random();
        myMail.append(mailType[randomMailType.nextInt(mailType.length)]);
        return myMail.toString();
    }
}
