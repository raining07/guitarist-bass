package com.xpizza.bass.sql.dynamicquery.clauses;

import com.xpizza.bass.lang.Strings;
import com.xpizza.bass.sql.dynamicquery.beans.Field;
import lombok.Data;

import java.util.List;

/**
 * 主句
 * SELECT ... FROM ...
 */
@Data
public class MainClause extends AbstractClause {
    private List<Field> fields;
    private String tableName;

    @Override
    protected String initModelSQL() {
        return "SELECT %s FROM %s";
    }

    @Override
    protected String handleSQL() {
        StringBuffer buffer = new StringBuffer();
        String separator = ", ";
        for (Field queryField : fields) {
            String field = queryField.getFieldName(); // 字段
            String alias = queryField.getAlias(); // 别名
            String selectField = Strings.isEmpty(alias) ? field : (field + " AS " + alias); // SELECT ... FROM 之间的字段表达式
            buffer.append(selectField).append(separator);
        }
        buffer.setLength(buffer.length() - separator.length());
        String selectFields = buffer.toString();
        String retSQL = String.format(getModelSQL(), selectFields, tableName);
        return retSQL;
    }
}
