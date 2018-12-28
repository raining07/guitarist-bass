package com.xpizza.bass.sql.dynamicquery.clauses;

public class LimitClause extends AbstractClause{
    @Override
    protected String initModelSQL() {
        return "LIMIT %s OFFSET %s";
    }

    @Override
    protected String handleSQL() {
        return null;
    }
}
