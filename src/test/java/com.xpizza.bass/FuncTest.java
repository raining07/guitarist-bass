package com.xpizza.bass;

import com.xpizza.bass.io.IOUtil;
import com.xpizza.bass.io.file.FileReader;
import com.xpizza.bass.io.file.FileSimpleWriter;
import com.xpizza.bass.security.crypto.Base64Algorithm;
import com.xpizza.bass.security.crypto.MD5Algorithm;
import com.xpizza.bass.util.MapUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FuncTest {
    @Test
    public void substring(){
        String str = "a=1&b=2&";
        System.out.println(str.substring(0, str.length() - 1));
    }

    @Test
    public void nextLine() {
        String s = "第一行";
        s += IOUtil.nextLineWin;
        s += "第二行";
        System.out.println(s);
    }

    @Test
    public void testFileWriter() throws IOException {
        FileSimpleWriter fileWriter = new FileSimpleWriter();
        fileWriter.setFilePath("E:/tmp_file/testFileWriter.txt");
        fileWriter.setAppend(true);
        fileWriter.build();
        int bufferSize = fileWriter.getBufferSize();
        System.out.println(bufferSize);
        fileWriter.close();
    }

    @Test
    public void testFileReader() throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader();
            fileReader.setFilePath("E:/tmp_file/testFileWriter.txt");
            fileReader.build();
            System.out.println(fileReader.readEachLine());
        } catch (IOException e) {
            throw e;
        } finally {
            fileReader.close();
        }
    }

    @Test
    public void testMD5() {
        MD5Algorithm md5Algorithm = new MD5Algorithm();
        String encode = md5Algorithm.encode("123456");
        System.out.println(encode);
    }

    @Test
    public void testBase64() throws IOException {
        Base64Algorithm base64Algorithm = new Base64Algorithm();
        String imgBase64Str = base64Algorithm.encodeImage("E:/tmp_file/xxx.jpeg");
        System.out.println(imgBase64Str);
        base64Algorithm.decodeAndSaveImage(imgBase64Str, "E:/tmp_file/yyy.jpeg");
    }

    @Test
    public void testCloneMap() {
        Map<String, Object> sourceMap = new HashMap<>();
        sourceMap.put("a", "xxx");
        sourceMap.put("b", "xxx");
        Map<String, Object> cloneMap = MapUtil.cloneMap(sourceMap);
        sourceMap.put("a", "yyyy");
        sourceMap.put("d", "qqqqqq");
        System.out.println(sourceMap);
        System.out.println(cloneMap);
    }
}
