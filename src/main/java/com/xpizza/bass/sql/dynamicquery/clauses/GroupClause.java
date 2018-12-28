package com.xpizza.bass.sql.dynamicquery.clauses;

public class GroupClause extends AbstractClause{
    @Override
    protected String initModelSQL() {
        return "GROUP BY %s";
    }

    @Override
    protected String handleSQL() {
        return null;
    }
}
