package com.xpizza.bass.sql.dynamicquery;

import com.xpizza.bass.sql.dynamicquery.clauses.AbstractClause;

/**
 * 动态SQL
 */
public abstract class AbstractDynamicSQL {
    private String resultSQL;

    public String getResultSQL() {
        return resultSQL;
    }

    protected String assembleClauses(AbstractClause... clauses) {
        String blank = " ";
        StringBuffer buffer = new StringBuffer();
        for (AbstractClause clause : clauses) {
            if (clause != null) {
                buffer.append(clause.getResultSQL() + blank);
            }
        }
        return buffer.toString();
    }

    public void build() {
        this.resultSQL = buildSQL();
    }

    /** 构建SQL */
    protected abstract String buildSQL();
}
