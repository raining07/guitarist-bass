package com.xpizza.bass.sql.dynamicquery;

import com.xpizza.bass.sql.dynamicquery.clauses.*;
import lombok.Data;

/**
 * 数据SQL
 */
@Data
public class DataQuerySQL extends AbstractDynamicSQL {
    private MainClause mainClause;
    private JoinClause joinClause;
    private WhereClause whereClause;
    private GroupClause groupClause;
    private OrderClause orderClause;
    private LimitClause limitClause;

    @Override
    protected String buildSQL() {
        String retSQL = assembleClauses(mainClause, joinClause, whereClause, groupClause, orderClause, limitClause);
        return retSQL;
    }
}
