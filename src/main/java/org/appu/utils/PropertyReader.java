package org.appu.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    public static String getVakueForGivenKey(String key) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(key);
    }
}
