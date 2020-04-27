package com.avitool.develop.avitool.controllers;

import com.avitool.develop.avitool.converter.TranslateConverter;
import com.avitool.develop.avitool.service.generators.LoginGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class DzController {
    private ResponseModel responseModel = new ResponseModel();

    @GetMapping("/dz")
    public String getDzPage() {
        Map<String, List<String>> models = new HashMap<>();
        List<String> modelsForBMW = Arrays.asList("M5", "M8", "X3", "X1");
        List<String> modelsForNissan = Arrays.asList("Almera", "Juke", "Tiida", "X-Trail");
        List<String> modelsForLada = Arrays.asList("Granta", "Niva", "X-ray");
        List<String> modelsForAudi = Arrays.asList("Q5", "Q3");
        models.put("bmw", modelsForBMW);
        models.put("nissan", modelsForNissan);
        models.put("lada", modelsForLada);
        models.put("audi", modelsForAudi);
        responseModel.setModels(models);
        return "dz_page";
    }

    @GetMapping("/dz/getModels")
    public @ResponseBody
    List<String> getModels(@RequestParam String mark) {
        List<String> models = responseModel.getModels(mark);
        ResponseModel responseModel = new ResponseModel();
        Map<String, List<String>> m = new HashMap<>();
        m.put(mark, models);
        responseModel.setModels(m);
        return models;
    }

    @Autowired
    private LoginGenerator loginGenerator;

    @GetMapping("/dz/getData")
    public @ResponseBody
    List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add(loginGenerator.generate());
        }
        return list;
    }

    @GetMapping("/dz/getTranslate")
    public @ResponseBody
    String getTranslate(@RequestParam String text, @RequestParam String lang) {
        System.out.println(text);
        System.out.println(lang);
        String textAreaString = "";
        TranslateConverter converter = new TranslateConverter();
        if (!text.isEmpty()) {
            String sendLang;
            switch (lang) {
                case "en":
                    sendLang = Locale.ENGLISH.getLanguage();
                    break;
                case "fr":
                    sendLang = Locale.FRANCE.getLanguage();
                    break;
                default:
                    sendLang = "ru";
                    break;
            }
            textAreaString = converter.print(text, new Locale(sendLang));
            System.out.println(textAreaString);
        }
        return textAreaString;
    }
}
