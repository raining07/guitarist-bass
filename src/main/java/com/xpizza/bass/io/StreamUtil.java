package com.xpizza.bass.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtil {
    public static byte[] readAndCloseQuietly(InputStream inputStream) throws IOException {
        byte[] data;
        try {
            data = new byte[inputStream.available()];
            inputStream.read(data);
        } catch (IOException e) {
            throw e;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return data;
    }

    public static void writeAndCloseQuietly(OutputStream outputStream, byte[] data) throws IOException {
        try {
            outputStream.write(data);
            outputStream.flush();
        } catch (IOException e) {
            throw e;
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
