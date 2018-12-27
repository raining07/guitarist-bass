package com.xpizza.bass.security.crypto;

import com.xpizza.bass.io.Charset;
import com.xpizza.bass.io.StreamUtil;
import com.xpizza.bass.security.Decodable;
import com.xpizza.bass.security.Encodable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Algorithm implements Encodable, Decodable {
    private Charset charset;

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public Base64Algorithm() {
        this.charset = Charset.UTF8;
    }

    public Base64Algorithm(Charset charset) {
        this.charset = charset;
    }

    @Override
    public String decode(String encodedStr) throws UnsupportedEncodingException {
        byte[] decodedBytes = decodeToBytes(encodedStr);
        return new String(decodedBytes, this.charset.getValue());

    }

    public byte[] decodeToBytes(String encodedStr){
        return Base64.getDecoder().decode(encodedStr);
    }

    public void decodeAndSaveImage(String imageBase64String, String imageSavePath) throws IOException {
        byte[] bytes = decodeToBytes(imageBase64String);
        FileOutputStream fileOutputStream = new FileOutputStream(imageSavePath);
        StreamUtil.writeAndCloseQuietly(fileOutputStream, bytes);
    }

    @Override
    public String encode(String originStr) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(originStr.getBytes(this.charset.getValue()));
    }

    public String encodeImage(String imagePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(imagePath);
        byte[] data = StreamUtil.readAndCloseQuietly(fileInputStream);
        byte[] decodedBytes = Base64.getEncoder().encode(data);
        return new String(decodedBytes, this.charset.getValue());
    }
}
