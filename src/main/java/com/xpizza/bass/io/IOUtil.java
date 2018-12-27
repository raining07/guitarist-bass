package com.xpizza.bass.io;

import com.xpizza.bass.lang.Strings;

import java.io.File;
import java.io.IOException;

/**
 *
 * @ClassName: IOUtil
 * @Description: TODO 流操作工具
 * @author: Xpizza
 * @date: Jul 6, 2017 1:59:33 PM
 */
public class IOUtil {
    /** 1KB */
    public static final int ONE_KB = 1024;
    /** 1MB */
    public static final int ONE_MB = ONE_KB * ONE_KB;
    /** 1GB */
    public static final int ONE_GB = ONE_KB * ONE_MB;

    /** 作为文件名的非法字符 */
    public static final String[] ILLEGAL_STRINGS = { "\\", "/", ":", "*", "?", "<", ">", "|" };

    /** windows换行符 */
    public static final String nextLineWin = "\r\n";

    /** unix换行符 */
    public static final String nextLineUnix = "\n";

    /** Mac换行符 */
    public static final String nextLineMac = "\r";

    /**
     *
     * @Title: createDirecoryIfNotExists
     * @Description: TODO 如果一个目录不存在就创建它
     * @param path
     *            目录全路径
     * @return: void
     */
    public static void createDirecoryIfNotExists(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     *
     * @Title: createFileIfNotExists
     * @Description: TODO 如果一个文件不存在就创建它
     * @param path
     *            文件全路径
     * @throws IOException
     *             读写异常
     * @return: void
     */
    public static void createFileIfNotExists(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    /**
     *
     * @Title: clearFolder
     * @Description: TODO 深度清理文件夹
     * @param folderPath
     *            文件夹的全路径
     * @return 清理成功返回true,否则返回false
     * @return: boolean
     */
    public static boolean clearFolder(String folderPath) {
        if (Strings.isEmpty(folderPath)) {
            return false;
        }
        File folderFile = new File(folderPath);
        if (!folderFile.exists()) {
            createDirecoryIfNotExists(folderPath);
            return true;
        }
        File[] fileList = folderFile.listFiles();
        for (File childFile : fileList) {
            if (childFile.isFile()) {
                if (!childFile.delete())
                    return false;
            } else if (childFile.isDirectory()) {
                clearFolder(childFile.getPath());
                if (!childFile.delete())
                    return false;
            }
        }
        return true;
    }

    /**
     *
     * @Title: getLegalFilename
     * @Description: 获取合法的文件名
     * @param oldFilename
     * @return
     * @return: String
     */
    public static String getLegalFilename(String oldFilename) {
        for (String illegalString : ILLEGAL_STRINGS) {
            oldFilename = oldFilename.replaceAll(illegalString, "");
        }
        return oldFilename;
    }

    /**
     *
     * @Title: getSysTmpDir
     * @Description: 获取操作系统临时目录
     * @return
     * @return: String
     */
    public static String getSysTmpDir() {
        return System.getProperty("java.io.tmpdir");
    }

    /** 获取系统的换行符 */
    public static String getSysNextLine() {
        return System.lineSeparator();
    }
}
