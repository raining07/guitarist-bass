package com.xpizza.bass.math;

import com.xpizza.bass.lang.Strings;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 数据处理工具
 */
public class BigDecimals {
    /**
     *
     * @Title: toBigDecimal
     * @Description: TODO Object转为BigDecimal
     * @param object
     *            原Object类型数据
     * @return BigDecimal类型数据
     * @return: BigDecimal
     */
    public static BigDecimal toBigDecimal(Object object) {
        return Strings.isEmpty(object) ? BigDecimal.ZERO : new BigDecimal(object.toString());
    }

    /**
     *
     * @Title: remainPlaces
     * @Description: TODO 根据需要保留小数位数
     * @param oldData
     *            原数据
     * @param places
     *            保留的小数位数
     * @return 处理之后的数据
     * @return: BigDecimal
     */
    public static BigDecimal remainPlaces(BigDecimal oldData, int places) {
        if (null == oldData || BigDecimal.ZERO.equals(oldData)) {
            return BigDecimal.ZERO;
        }
        return oldData.setScale(places, RoundingMode.HALF_UP);
    }
}
