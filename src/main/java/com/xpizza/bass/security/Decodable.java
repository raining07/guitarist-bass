package com.xpizza.bass.security;

import java.io.UnsupportedEncodingException;

/**
 * 可解码接口
 */
public interface Decodable {
    /** 解码 */
    String decode(String encodedStr) throws UnsupportedEncodingException;
}
