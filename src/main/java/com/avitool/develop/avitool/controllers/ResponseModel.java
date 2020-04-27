package com.avitool.develop.avitool.controllers;

import java.util.List;
import java.util.Map;

public class ResponseModel {
    private Map<String, List<String>> models;

    public Map<String, List<String>> getModels() {
        return models;
    }

    public List<String> getModels(String key) {
        return this.models.get(key);
    }

    public void setModels(Map<String, List<String>> models) {
        this.models = models;
    }
}
