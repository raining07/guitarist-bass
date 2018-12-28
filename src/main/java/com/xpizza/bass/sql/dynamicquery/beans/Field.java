package com.xpizza.bass.sql.dynamicquery.beans;

import lombok.Data;

@Data
public class Field {
    /** 字段名, 可以是复杂的表达式 */
    private String fieldName;
    /** 别名 */
    private String alias;
    /** 字段类型 */
    private FieldType fieldType;
}
