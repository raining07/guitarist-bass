package com.xpizza.bass.lang;

import com.xpizza.bass.lang.exception.TypeCastException;

/**
 * 数字类型工具
 */
public class Numbers {
    public static int toInt(Object object) {
        if (object == null) {
            return 0;
        }
        if (object instanceof Number) {
            return ((Number) object).intValue();
        }
        if (object instanceof String) {
            String str = (String) object;
            if ("".equals(str)) {
                return 0;
            }
            return Integer.valueOf(str);
        }
        throw new TypeCastException(object + "不能转为整型");
    }
}
