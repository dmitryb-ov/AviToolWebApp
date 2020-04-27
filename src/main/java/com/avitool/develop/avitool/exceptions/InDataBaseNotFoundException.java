package com.avitool.develop.avitool.exceptions;

public class InDataBaseNotFoundException extends Exception {
    private int num;

    public int getNum() {
        return num;
    }

    public InDataBaseNotFoundException(String message) {
        super(message);
    }

    public InDataBaseNotFoundException(String message, int id) {
        super(message);
        num = id;
    }
}
