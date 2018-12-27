package com.xpizza.bass.util;

import java.util.UUID;

/**
 *
 * @ClassName: UUIDs
 * @Description: TODO UUID产生工具
 * @author: Xpizza
 * @date: Jul 14, 2017 11:03:56 AM
 */
public class UUIDs {

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