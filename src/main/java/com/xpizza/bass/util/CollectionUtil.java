package com.xpizza.bass.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @ClassName: CollectionUtil
 * @Description: TODO 集合操作工具
 * @author: Xpizza
 * @date: Jul 14, 2017 10:31:23 AM
 */
public class CollectionUtil {
    /**
     *
     * @Title: isEmpty
     * @Description: TODO 判断集合是否为空
     * @param collection
     *            集合
     * @return 如果集合为空,则返回true,否则返回false
     * @return: boolean
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     *
     * @Title: isNotEmpty
     * @Description: TODO 判断集合是否不为空
     * @param collection
     *            集合
     * @return 如果集合不为空,则返回true,否则返回false
     * @return: boolean
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     *
     * @Title: collectionToString
     * @Description: 集合转为字符串,用逗号分隔
     * @param collection
     *            集合
     * @return 字符串,用逗号分隔
     * @return: String
     */
    public static String collectionToString(Collection<?> collection) {
        if (collection.size() <= 0)
            return "";
        StringBuffer sb = new StringBuffer();
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(",");
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
    }

    /**
     *
     * @Title: collectionToStringWithSingleQuote
     * @Description: TODO 集合转带单引号的字符串,用逗号分隔
     * @param collection
     *            集合
     * @return 带单引号的字符串,用逗号分隔
     * @return: String
     */
    public static String collectionToStringWithSingleQuote(Collection<?> collection) {
        StringBuffer result = new StringBuffer();
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            result.append("'").append(iterator.next()).append("',");
        }
        return result.substring(0, result.length() - 1);
    }
}
