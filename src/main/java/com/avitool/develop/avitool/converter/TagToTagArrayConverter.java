package com.avitool.develop.avitool.converter;

import org.springframework.core.convert.converter.Converter;

public class TagToTagArrayConverter implements Converter<String, String[]> {
    @Override
    public String[] convert(String tag) {
        if (tag.contains(",")) {
            return tag.split(",");
        } else {
            return new String[]{tag};
        }
    }
}
