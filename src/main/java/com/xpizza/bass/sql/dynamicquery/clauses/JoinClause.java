package com.xpizza.bass.sql.dynamicquery.clauses;

import com.xpizza.bass.sql.dynamicquery.beans.JoinPoint;
import com.xpizza.bass.sql.dynamicquery.beans.JoinRelation;
import com.xpizza.bass.util.CollectionUtil;
import lombok.Data;

import java.util.List;

/**
 * Join从句
 */
@Data
public class JoinClause extends AbstractClause{
    private String mainTable;
    private List<JoinRelation> joinRelations;

    @Override
    protected String initModelSQL() {
        return "";
    }

    @Override
    protected String handleSQL() {
        if (CollectionUtil.isEmpty(joinRelations)) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        // left join assistTable on assistTable.assistField = mainTable.mainField
        String andSeparator = " AND "; // 多个连接点用AND隔开
        String blankSeparator = " "; // 多个连接关系用空格隔开
        for (JoinRelation joinRelation : joinRelations) {
            String assistTable = joinRelation.getAssistTable();
            buffer.append(joinRelation.getJoinMethod()).append(" ").append(assistTable).append(" ON ");
            List<JoinPoint> joinPoints = joinRelation.getJoinPoints();
            boolean needsParentheses = joinPoints.size() > 1 ? true : false;
            if (needsParentheses) {
                buffer.append("(");
            }
            for (JoinPoint joinPoint : joinPoints) {
                buffer.append(assistTable + "." + joinPoint.getAssistField() + " = " + mainTable + "." + joinPoint.getMainField());
                buffer.append(andSeparator);
            }
            buffer.setLength(buffer.length() - andSeparator.length());
            if (needsParentheses) {
                buffer.append(")");
            }
            buffer.append(blankSeparator);
        }
        buffer.setLength(buffer.length() - blankSeparator.length());
        return buffer.toString();
    }
}
