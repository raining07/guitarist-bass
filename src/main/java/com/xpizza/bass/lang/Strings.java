package com.xpizza.bass.lang;

import java.io.UnsupportedEncodingException;

/**
 *
 * @ClassName: Strings
 * @Description: TODO 字符串处理工具
 * @author: Xpizza
 * @date: Jul 6, 2017 2:14:13 PM
 */
public class Strings {

    /**
     *
     * @Title: isEmpty
     * @Description: TODO 判断一个字符串或数组是否为空
     * @param object
     *            被判断的字符串
     * @return 字符串为空,返回true,否则返回false
     * @return: boolean
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object.getClass().isArray()) {
            return ((Object[]) object).length == 0;
        }
        return object.toString().length() == 0;
    }

    /**
     *
     * @Title: isNotEmpty
     * @Description: TODO 判断一个字符串是否不为空
     * @param string
     *            被判断的字符串
     * @return 字符串不为空,则返回true,否则返回true
     * @return: boolean
     */
    public static boolean isNotEmpty(Object string) {
        return !isEmpty(string);
    }

    /**
     *
     * @Title: toString
     * @Description: TODO 将Object转为String,如果Object为null,则给默认值
     * @param object
     *            被转化为String的对象
     * @param dftVal
     *            默认值
     * @return 字符串
     * @return: String
     */
    public static String toString(Object object, String dftVal) {
        return object == null ? dftVal : object.toString();
    }

    /**
     *
     * @Title: toString
     * @Description: TODO 将Object转为String,如果Object为null,则返回""
     * @param object
     *            被转化为String的对象
     * @return 字符串
     * @return: String
     */
    public static String toString(Object object) {
        return toString(object, "");
    }

    /**
     *
     * @Title: toUtf8String
     * @Description: TODO 把一个字符串转为UTF-8编码的形式
     * @param oldString
     *            旧字符串
     * @param oldEncoding
     *            旧字符串的编码
     * @return UTF-8编码形式的字符串
     * @throws UnsupportedEncodingException
     * @return: String
     */
    public static String toUtf8String(String oldString, String oldEncoding) throws UnsupportedEncodingException {
        return new String(oldString.getBytes(oldEncoding), "UTF-8");
    }

}
