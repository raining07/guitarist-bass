package com.xpizza.bass.io.file;

import com.xpizza.bass.io.SimpleReader;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @ClassName: FileReader
 * @Description: TODO 文件阅读器
 * @author: Xpizza
 * @date: Jul 6, 2017 1:59:10 PM
 */
public class FileReader extends SimpleReader {
    /** 文件路径 */
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void build() throws IOException {
        super.setInputStream(new FileInputStream(filePath));
        super.build();
    }
}
