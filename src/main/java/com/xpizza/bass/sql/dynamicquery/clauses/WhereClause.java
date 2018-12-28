package com.xpizza.bass.sql.dynamicquery.clauses;

import lombok.Data;

@Data
public class WhereClause extends AbstractClause{

    @Override
    protected String initModelSQL() {
        return "WHERE %s";
    }

    @Override
    protected String handleSQL() {
        return null;
    }
}
