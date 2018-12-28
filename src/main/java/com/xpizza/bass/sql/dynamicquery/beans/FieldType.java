package com.xpizza.bass.sql.dynamicquery.beans;

/**
 * 字段类型
 */
public enum FieldType {
    Number("number", "数值型"),
    Date("date", "日期类型"),
    String("string", "字符类型");

    private String typeCode;
    private String typeName;

    FieldType(java.lang.String typeCode, java.lang.String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public java.lang.String getTypeCode() {

        return typeCode;
    }

    public java.lang.String getTypeName() {
        return typeName;
    }
}
