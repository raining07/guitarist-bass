package com.xpizza.bass.util;

import java.util.Arrays;

/**
 *
 * @ClassName: ArrayUtil
 * @Description: TODO 数组工具
 * @author: Xpizza
 * @date: Jul 9, 2017 10:10:51 AM
 */
public class ArrayUtil {

    /**
     *
     * @Title: isEmpty
     * @Description: TODO 判断数组是否为空
     * @param array
     *            数组
     * @return 如果数组为null或长度为0,则返回true,否则返回false
     * @return: boolean
     */
    public static <T> boolean isEmpty(T[] array) {
        if (array == null) {
            return true;
        } else if (array.length == 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * @Title: isNotEmpty
     * @Description: TODO 判断数组是否不为空
     * @param array
     *            数组
     * @return 如果数组不为空,则返回true,否则返回false
     * @return: boolean
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }

    /**
     *
     * @Title: arrayToString
     * @Description: TODO 将数组转为字符串,用逗号隔开
     * @param array
     *            数组
     * @return 字符串,用逗号隔开
     * @return: String
     */
    public static <T> String arrayToString(T[] array) {
        if (array.length == 0)
            return "";
        StringBuffer sb = new StringBuffer();
        for (Object each : array) {
            sb.append(each).append(",");
        }
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
    }

    /**
     *
     * @Title: concatAll
     * @Description: TODO 合并多个数组
     * @param first
     *            第一个数组
     * @param rest
     *            其余数组
     * @return 合并之后的大数组
     * @return: T[]
     */
    public static <T> T[] concatAll(T[] first, @SuppressWarnings("unchecked") T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
