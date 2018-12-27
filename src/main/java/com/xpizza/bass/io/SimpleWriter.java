package com.xpizza.bass.io;

import java.io.*;
import java.util.List;

public class SimpleWriter implements Closeable {
    /** 编码格式,默认为UTF-8 */
    private Charset charset = Charset.UTF8;

    private OutputStream outputStream;

    /** 缓冲区大小 */
    private int bufferSize;

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    private BufferedWriter writer;

    public void build() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, this.charset.getValue());
        if (this.bufferSize > 0) {
            this.writer = new BufferedWriter(outputStreamWriter, bufferSize);
        }else {
            this.writer = new BufferedWriter(outputStreamWriter);
        }
    }

    /** 写一行 */
    public void writeOneLine(String oneLine) throws IOException {
        this.writer.write(oneLine + IOUtil.getSysNextLine());
    }

    /** 写多行 */
    public void writeLines(List<String> lines) throws IOException {
        for (String line : lines) {
            writeOneLine(line);
        }
    }

    /** 冲刷出流 */
    public void flush () throws IOException {
        this.writer.flush();
    }

    @Override
    public void close() throws IOException {
        this.writer.close();
    }
}
