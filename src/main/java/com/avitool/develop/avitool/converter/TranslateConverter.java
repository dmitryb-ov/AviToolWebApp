package com.avitool.develop.avitool.converter;

import org.springframework.format.Printer;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.Locale;

public class TranslateConverter implements Printer<String> {
    @Override
    @NonNull
    public String print(@NonNull String string, Locale locale) {
        try {
            return Translator.translate(locale.getLanguage(), string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "null";
    }
}
