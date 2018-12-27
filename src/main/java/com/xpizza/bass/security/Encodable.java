package com.xpizza.bass.security;

import java.io.UnsupportedEncodingException;

/**
 * 可编码接口
 */
public interface Encodable {
    /** 编码 */
    String encode(String originStr) throws UnsupportedEncodingException;
}
