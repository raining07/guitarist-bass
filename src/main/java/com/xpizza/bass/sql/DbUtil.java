package com.xpizza.bass.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作工具
 */
public class DbUtil {
    /**
     * 释放数据库资源工具
     * @param rs
     * @param stmt
     * @param conn
     * @throws SQLException
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        release(stmt, conn);
    }

    /**
     * 释放数据库资源工具
     * @param stmt
     * @param conn
     * @throws SQLException
     */
    public static void release(Statement stmt, Connection conn)  {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
