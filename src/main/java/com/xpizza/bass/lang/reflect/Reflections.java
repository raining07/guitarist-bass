package com.xpizza.bass.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 反射工具
 */
public class Reflections {
    /**
     * 对象转Map
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }

    /**
     * Map转对象
     * @param map
     * @param clz
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T mapToObj(Map<String, Object> map, Class<T> clz) throws IllegalAccessException, InstantiationException {
        T obj = clz.newInstance();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }
        return obj;
    }

    /**
     * Map List转对象List
     * @param list
     * @param clz
     * @param <T>
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> List<T> mapListToObjList(List<Map<String, Object>> list, Class<T> clz) throws InstantiationException, IllegalAccessException {
        List<T> retList = new ArrayList<>();
        for (Map<String, Object> each : list) {
            T obj = mapToObj(each, clz);
            retList.add(obj);
        }
        return retList;
    }

    /**
     * 对象List转Map List
     * @param list
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<Map<String, Object>> objListToMapList(List<T> list) throws Exception {
        List<Map<String, Object>> retList = new ArrayList<>();
        for (T obj : list) {
            Map<String, Object> map = objToMap(obj);
            retList.add(map);
        }
        return retList;
    }
}
