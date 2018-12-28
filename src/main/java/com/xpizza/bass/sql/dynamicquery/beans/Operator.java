package com.xpizza.bass.sql.dynamicquery.beans;

/**
 * AND field1 = 'xxx'
 * AND field2 IN ('2','3')
 * AND field3 NOT IN ('2','3')
 * AND field4 > 2
 * AND field5 >= 2
 * AND field6 < 2
 * AND field7 <= 2
 * AND field8 BETWEEN 5 AND 10
 * AND field9 LIKE '%xxx%'
 */
public enum Operator {
    equal("="),
    or("OR");

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }
}
