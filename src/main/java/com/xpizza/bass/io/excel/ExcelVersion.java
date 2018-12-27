package com.xpizza.bass.io.excel;

public enum ExcelVersion {
    V_2007("xlsx", "2007以上版本"),
    V_2003("xls", "2003版本");

    private String suffix;
    private String comment;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    ExcelVersion(String suffix, String comment) {
        this.suffix = suffix;
        this.comment = comment;
    }
}
