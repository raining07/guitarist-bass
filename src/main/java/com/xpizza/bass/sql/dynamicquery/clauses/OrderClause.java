package com.xpizza.bass.sql.dynamicquery.clauses;

public class OrderClause extends AbstractClause{
    @Override
    protected String initModelSQL() {
        return "ORDER BY %s";
    }

    @Override
    protected String handleSQL() {
        return null;
    }
}
