package com.xpizza.bass.io;

public enum Charset {
    UTF8("UTF-8");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Charset(String value) {
        this.value = value;
    }
}
