package com.xpizza.bass.sql.dynamicquery.clauses;

/**
 * 从句基类
 */
public abstract class AbstractClause {
    private String resultSQL;
    private String modelSQL = initModelSQL();

    /** 初始化模板SQL */
    protected abstract String initModelSQL();

    public String getResultSQL() {
        return resultSQL;
    }

    public void setResultSQL(String resultSQL) {
        this.resultSQL = resultSQL;
    }

    public String getModelSQL() {
        return modelSQL;
    }

    /** 转化SQL */
    public void build() {
        resultSQL = handleSQL();
    }

    /** 拼装SQL */
    protected abstract String handleSQL();
}
