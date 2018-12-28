package com.xpizza.bass.sql.dynamicquery.beans;

import lombok.Data;

import java.util.List;

@Data
public class JoinRelation {
    private String joinMethod;
    private String assistTable;
    private List<JoinPoint> joinPoints;
}
