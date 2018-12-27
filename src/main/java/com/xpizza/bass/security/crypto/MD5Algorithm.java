package com.xpizza.bass.security.crypto;

import com.xpizza.bass.io.Charset;
import com.xpizza.bass.security.Encodable;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5算法
 */
public class MD5Algorithm implements Encodable {
    private Charset charset;

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public MD5Algorithm() {
        this.charset = Charset.UTF8;
    }

    public MD5Algorithm(Charset charset) {
        this.charset = charset;
    }

    @Override
    public String encode(String originStr) {
        try {
            byte[] hash = MessageDigest.getInstance("MD5").digest(originStr.getBytes(this.charset.getValue()));
            StringBuilder hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & 0xFF) < 0x10)
                    hex.append("0");
                hex.append(Integer.toHexString(b & 0xFF));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, " + this.charset.getValue() + " should be supported?", e);
        }
    }
}
