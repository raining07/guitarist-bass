package com.xpizza.bass.sql;

import com.xpizza.bass.lang.reflect.Reflections;
import com.xpizza.bass.util.ArrayUtil;
import com.xpizza.bass.util.CollectionUtil;
import com.xpizza.bass.util.MapUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库访问器
 */
public class DbAccessor {
    /** 数据库配置 */
    private DbConfig dbConfig;

    private Connection connection;

    public DbConfig getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public DbAccessor(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    /** 执行SQL */
    public void execute(String sql) {
        Statement stmt = null;
        try {
            buildConnection(this.dbConfig);
            stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (Throwable thr) {
            throw new RuntimeException(thr);
        } finally {
            DbUtil.release(stmt, connection);
        }
    }

    /** 批处理 */
    public void batchExecute(List<String> sqls) {
        Statement stmt = null;
        try {
            buildConnection(this.dbConfig);
            stmt = connection.createStatement();
            for (String each : sqls) {
                stmt.addBatch(each);
            }
            stmt.executeBatch();
        } catch (Throwable thr) {
            thr.printStackTrace();
        } finally {
            DbUtil.release(stmt, connection);
        }
    }

    /**
     * 查询 返回Map List
     * @param querySQL
     * @return
     */
    public List<Map<String, Object>> queryForList(String querySQL) {
        List<Map<String, Object>> retList = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            buildConnection(this.dbConfig);
            stmt = connection.createStatement();
            rs = stmt.executeQuery(querySQL);
            ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据
            int columnCount = md.getColumnCount();   //获得列数
            while (rs.next()) {
                Map<String,Object> rowData = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnLabel(i), rs.getObject(i));
                }
                retList.add(rowData);
            }
        } catch (Throwable thr) {
            throw new RuntimeException(thr);
        } finally {
            DbUtil.release(rs, stmt, connection);
        }
        return retList;
    }

    /**
     * 查询 返回Map
     * @param querySQL
     * @return
     */
    public Map<String, Object> queryForMap(String querySQL) {
        List<Map<String, Object>> list = queryForList(querySQL);
        return CollectionUtil.isEmpty(list) ? null : list.get(0);
    }

    /**
     * 查询 返回对象List
     * @param querySQL
     * @param clazz
     * @param <T>
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T> List<T> queryForObjects(String querySQL, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<Map<String, Object>> list = queryForList(querySQL);
        List<T> retList = new ArrayList<>();
        for (Map<String, Object> item : list) {
            T t = Reflections.mapToObj(item, clazz);
            retList.add(t);
        }
        return retList;
    }

    /**
     * 查询 返回一个对象
     * @param querySQL
     * @param clazz
     * @param <T>
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T> T queryForObject(String querySQL, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        Map<String, Object> map = queryForMap(querySQL);
        return Reflections.mapToObj(map, clazz);
    }

    /**
     * 查询 返回一列数据的值
     * @param querySQL
     * @return
     */
    public Object[] queryForValsOfOneColumn(String querySQL){
        Map<String, Object> map = queryForMap(querySQL);
        return MapUtil.isEmpty(map) ? new Object[0] : map.values().toArray();
    }

    /**
     * 查询 返回单个值
     * @param querySQL
     * @return
     */
    public Object queryForSingleVal(String querySQL){
        Object[] objects = queryForValsOfOneColumn(querySQL);
        if (ArrayUtil.isEmpty(objects)) {
            return null;
        }
        return objects[0];
    }

    /**
     * 查出的结果中,以某个字段的值为Key,另一个字段的值为Val
     * @param querySQL
     * @param keyKey
     * @param valKey
     * @return
     */
    public Map<Object, Object> queryForValuesMapping(String querySQL, String keyKey, String valKey) {
        List<Map<String, Object>> list = queryForList(querySQL);
        Map<Object, Object> retMapping = new LinkedHashMap<>();
        for (Map<String, Object> line : list) {
            retMapping.put(line.get(keyKey), line.get(valKey));
        }
        return retMapping;
    }

    private void buildConnection(DbConfig dbConfig) throws SQLException, ClassNotFoundException {
        this.connection = DbUtil.getConnection(dbConfig);
    }
}
