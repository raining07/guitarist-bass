package com.xpizza.bass.net.http;

/**
 * 请求方式
 */
public enum RequestMethod {
    GET("GET"),
    POST("POST"),
    DELETE("DELETE"),
    PUT("PUT");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    RequestMethod(String value) {
        this.value = value;
    }
}
