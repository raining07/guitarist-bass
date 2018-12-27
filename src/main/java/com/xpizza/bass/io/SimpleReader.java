package com.xpizza.bass.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleReader implements Closeable {
    /**
     * 编码格式,默认为UTF-8
     */
    private Charset charset = Charset.UTF8;

    private InputStream inputStream;

    /**
     * 按行读时记录当前行号
     */
    private int currlineNo = 0;

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int getCurrlineNo() {
        return currlineNo;
    }

    public void setCurrlineNo(int currlineNo) {
        this.currlineNo = currlineNo;
    }

    /**
     * 带缓冲区的阅读器
     */
    private BufferedReader reader;

    public void build() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset.getValue());// 考虑到编码格式
        this.reader = new BufferedReader(inputStreamReader);
    }

    /**
     * 读取输入流,返回list
     */
    public List<String> readAllAsList() throws IOException {
        List<String> resultList = new ArrayList<>();
        String line;
        while ((line = this.reader.readLine()) != null) {
            resultList.add(line);
        }
        return resultList;
    }

    /**
     * 读取输入流,返回一行string
     */
    public String readAllAsString() throws IOException {
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

    /**
     * 读取输入流,返回多行string
     */
    public String readAllAsStringWithLineSeparator() throws IOException {
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = this.reader.readLine()) != null) {
            buffer.append(line + System.lineSeparator());
        }
        return buffer.toString();
    }

    /**
     * 按行读
     */
    public String readEachLine() throws IOException {
        currlineNo++;
        return reader.readLine();
    }

    @Override
    public void close() throws IOException {
        if (this.reader != null) {
            reader.close();
        }
    }
}
