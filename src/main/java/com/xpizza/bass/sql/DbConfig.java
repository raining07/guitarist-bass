package com.xpizza.bass.sql;

import lombok.Data;

@Data
public class DbConfig {
    private String driver;
    private String url;
    private String username;
    private String password;
}
