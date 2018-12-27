package com.xpizza.bass.util;

import com.xpizza.bass.lang.Strings;
import com.xpizza.bass.lang.exception.EmptyDataException;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @ClassName: Assert
 * @Description:断言工具类<br/>
 * 						使用场景: <br/>
 *                         1.判断字符串,集合是否为空;<br/>
 *                         2.做业务之前,事先判断先决条件,比如参数是否齐全,表单是否完整.
 * @author: Xpizza
 * @date: Jul 14, 2017 9:19:07 AM
 */
public abstract class Assert {

    /**
     *
     * @Title: isTrue
     * @Description: TODO 断言真假
     * @param expression
     *            布尔表达式
     * @param reason
     *            不满足条件的原因
     * @return: void
     */
    public static void isTrue(boolean expression, String reason) {
        if (!expression) {
            throw new IllegalArgumentException(reason);
        }
    }

    /**
     *
     * @Title: isNotEmpty
     * @Description: TODO 断言字符串不为空
     * @param string
     *            字符串
     * @param reason
     *            不满足条件的原因
     * @return: void
     */
    public static void isNotEmpty(String string, String reason) {
        if (Strings.isEmpty(string)) {
            throw new EmptyDataException(reason);
        }
    }

    /**
     *
     * @Title: isNotNull
     * @Description: TODO 断言对象不为空
     * @param object
     *            对象
     * @param reason
     *            不满足条件的原因
     * @return: void
     */
    public static void isNotNull(Object object, String reason) {
        if (object == null) {
            throw new NullPointerException(reason);
        }
    }

    /**
     *
     * @Title: isNotEmpty
     * @Description: TODO 断言集合不为空
     * @param collection
     *            集合
     * @param reason
     *            不满足条件的原因
     * @return: void
     */
    public static void isNotEmpty(Collection<?> collection, String reason) {
        if (collection == null || collection.size() <= 0) {
            throw new EmptyDataException(reason);
        }
    }

    /**
     *
     * @Title: isNotEmpty
     * @Description: TODO 断言Map不为空
     * @param map
     *            Map
     * @param reason
     *            不满足条件的原因
     * @return: void
     */
    public static <K, V> void isNotEmpty(Map<K, V> map, String reason) {
        if (map == null || map.size() <= 0) {
            throw new EmptyDataException(reason);
        }
    }

    /**
     *
     * @Title: strsNotEmpty
     * @Description: 断言多个字符串都不为空
     * @param reason
     *            不满足条件的原因
     * @param strs
     * @return: void
     */
    public static void strsNotEmpty(String reason, String... strs) {
        for (String str : strs) {
            isNotEmpty(str, reason);
        }
    }

}
