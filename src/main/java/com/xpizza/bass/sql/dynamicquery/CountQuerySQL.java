package com.xpizza.bass.sql.dynamicquery;

import com.xpizza.bass.sql.dynamicquery.clauses.GroupClause;
import com.xpizza.bass.sql.dynamicquery.clauses.JoinClause;
import com.xpizza.bass.sql.dynamicquery.clauses.MainClause;
import com.xpizza.bass.sql.dynamicquery.clauses.WhereClause;
import lombok.Data;

/**
 * 总数SQL
 */
@Data
public class CountQuerySQL extends AbstractDynamicSQL {
    private MainClause mainClause;
    private JoinClause joinClause;
    private WhereClause whereClause;
    private GroupClause groupClause;

    @Override
    protected String buildSQL() {
        String countSQLModel = "SELECT COUNT(1) FROM (%s) AS FOO";
        String tempSQL = assembleClauses(mainClause, joinClause, whereClause, groupClause);
        String retSQL = String.format(countSQLModel, tempSQL);
        return retSQL;
    }
}
