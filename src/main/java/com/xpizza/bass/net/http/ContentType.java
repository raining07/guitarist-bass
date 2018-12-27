package com.xpizza.bass.net.http;

public enum ContentType {
    JavaSerializedObject("application/x-java-serialized-object"),
    ApplicationJson("application/json"),
    ApplicationForm("application/x-www-form-urlencoded");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    ContentType(String value) {
        this.value = value;
    }
}
