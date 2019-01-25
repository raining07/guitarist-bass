package com.xpizza.bass.util;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @ClassName: PropertiesUtil
 * @Description: TODO 属性工具
 * @author: Xpizza
 * @date: Jul 14, 2017 10:53:01 AM
 */
public class PropertiesUtil {

    /**
     *
     * @Title: loadProperties
     * @Description: TODO 从文件中读取所有属性,返回一个Map
     * @param fileName
     *            文件名
     * @return properties文件的所有键值对
     * @return: Map<String,String>
     */
    public static Map<String, String> loadProperties(String fileName) {
        Map<String, String> map = new HashMap<String, String>();
        Properties properties = new Properties();
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName));
            Enumeration<?> en = properties.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String value = properties.getProperty(key);
                map.put(key, value);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @Title: getProperty
     * @Description: TODO 从文件中读取一个属性,获取它的值
     * @param fileName
     *            文件名
     * @param key
     *            属性Key
     * @return 属性的值
     * @return: String
     */
    public static String getProperty(String fileName, String key) {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName));
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setPropertyByKey(String filePath, String key, String value) throws IOException {
        InputStream fis = null;
        OutputStream fos = null;
        try {
            // 获取绝对路径
            filePath = PropertiesUtil.class.getResource("/" + filePath).toString();
            // 截掉路径的”file:/“前缀
            filePath = filePath.substring(6);
            Properties prop = new Properties();
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fis = new FileInputStream(file);
            prop.load(fis);
            // 一定要在修改值之前关闭fis
            fis.close();
            fos = new FileOutputStream(filePath);
            prop.setProperty(key, value);
            // 保存，并加入注释
            prop.store(fos, "Update '" + key + "' value");
        } catch (IOException e) {
            throw e;
        } finally {
            fos.close();
        }
    }

}