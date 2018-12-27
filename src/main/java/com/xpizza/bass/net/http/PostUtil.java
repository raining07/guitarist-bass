package com.xpizza.bass.net.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;

public class PostUtil {
    /** post请求,发送参数 */
    public static void output(URLConnection connection, String paramStr) throws IOException {
        byte[] bytes = paramStr.getBytes();
        connection.setRequestProperty(RequestProperty.ContentLength, String.valueOf(bytes.length)); // 设置上下文长度
        OutputStream out = null;
        try {
            out = connection.getOutputStream();
            out.write(bytes);
            out.flush();
        } catch (Throwable thr) {
            throw new FetcherSendRequestException();
        } finally {
            out.close();
        }
    }
}
