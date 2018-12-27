package com.xpizza.bass.net.http;

import com.xpizza.bass.io.Charset;
import com.xpizza.bass.io.SimpleReader;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;

@Data
public class HttpResponse {
    private int statusCode;
    private String message;
    private String body;

    public void pushBody(InputStream inputStream, Charset charset) throws IOException {
        SimpleReader simpleReader = new SimpleReader();
        try {
            simpleReader.setInputStream(inputStream);
            simpleReader.setCharset(charset);
            simpleReader.build();
            String result = simpleReader.readAllAsString();
            this.setBody(result);
        } catch (IOException e) {
            throw e;
        } finally {
            simpleReader.close();
        }
    }
}
