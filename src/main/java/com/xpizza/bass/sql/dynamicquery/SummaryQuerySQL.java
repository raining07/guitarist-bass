package com.xpizza.bass.sql.dynamicquery;

import com.xpizza.bass.sql.dynamicquery.clauses.JoinClause;
import com.xpizza.bass.sql.dynamicquery.clauses.MainClause;
import com.xpizza.bass.sql.dynamicquery.clauses.WhereClause;
import lombok.Data;

/**
 * 汇总SQL
 */
@Data
public class SummaryQuerySQL extends AbstractDynamicSQL {
    private MainClause mainClause;
    private JoinClause joinClause;
    private WhereClause whereClause;

    @Override
    protected String buildSQL() {
        String retSQL = assembleClauses(mainClause, joinClause, whereClause);
        return retSQL;
    }
}
