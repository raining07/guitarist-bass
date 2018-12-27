package com.xpizza.bass.io.file;

import com.xpizza.bass.io.SimpleWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileSimpleWriter extends SimpleWriter {
    /** 文件路径 */
    private String filePath;

    private boolean append;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    @Override
    public void build() throws IOException {
        super.setOutputStream(new FileOutputStream(this.filePath, this.append));
        super.build();
    }
}
