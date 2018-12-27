package com.xpizza.bass.lang;

public class Booleans {
    /**
     *
     * @Title: getBooleanValue
     * @Description: TODO 获取布尔值
     * @param object
     *            可能是布尔值的对象
     * @return 从输入对象中获取布尔值
     * @return: boolean
     */
    public static boolean getBooleanValue(Object object) {
        String string = Strings.toString(object);
        if (Strings.isEmpty(object)) {
            return false;
        }
        return "true".equalsIgnoreCase(string) || "1".equals(string);
    }
}
