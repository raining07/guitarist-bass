package com.xpizza.bass.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @ClassName: MapUtil
 * @Description: TODO Map工具
 * @author: Xpizza
 * @date: Jul 14, 2017 10:46:45 AM
 */
public class MapUtil {

    /**
     *
     * @Title: isEmpty
     * @Description: TODO 判断一个Map是否为空
     * @param map
     *            Map
     * @return 如果Map为null或者为空,则返回true,否则返回false
     * @return: boolean
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     *
     * @Title: isNotEmpty
     * @Description: TODO 判断一个Map是否不为空
     * @param map
     * @return 如果Map不为空,则返回true,否则返回false
     * @return: boolean
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     *
     * @Title: copyProps
     * @Description: TODO 复制某些属性
     * @param targetMap
     *            目标Map
     * @param sourceMap
     *            源Map
     * @param keys
     *            需要复制的属性
     * @return: void
     */
    public static void copyProps(Map<String, Object> targetMap, Map<String, Object> sourceMap, String... keys) {
        for (String key : keys) {
            targetMap.put(key, sourceMap.get(key));
        }
    }

    /**
     *
     * @Title: cutProps
     * @Description: TODO 剪切某些属性
     * @param targetMap
     *            目标Map
     * @param sourceMap
     *            源Map
     * @param keys
     *            需要剪切的属性
     * @return: void
     */
    public static void cutProps(Map<String, Object> targetMap, Map<String, Object> sourceMap, String... keys) {
        for (String key : keys) {
            targetMap.put(key, sourceMap.get(key));
            sourceMap.remove(key);
        }
    }

    /**
     *
     * @Title: cloneMap
     * @Description: TODO 克隆Map
     * @param sourceMap
     *            源Map
     * @return 一个与Map属性一致的Map
     * @return: Map<String,Object>
     */
    public static Map<String, Object> cloneMap(Map<String, Object> sourceMap) {
        Map<String, Object> targetMap = new HashMap<>();
        targetMap.putAll(sourceMap);
        return targetMap;
    }
}
