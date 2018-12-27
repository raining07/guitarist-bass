package com.xpizza.bass.util;

import java.util.UUID;

/**
 * UUID生成器
 */
public class Uuids {

    /**
     *
     * @Title: getUUID
     * @Description: TODO 得到一个UUID
     * @return UUID
     * @return: String
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().trim();
    }

    /**
     *
     * @Title: get32UUID
     * @Description: TODO 得到一个32的UUID
     * @return 32位的UUID
     * @return: String
     */
    public static String get32UUID() {
        return getUUID().replaceAll("-", "");
    }

}