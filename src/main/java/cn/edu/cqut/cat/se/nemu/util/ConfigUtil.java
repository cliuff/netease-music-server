package cn.edu.cqut.cat.se.nemu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ConfigUtil {
    public static String CONFIG_DEFAULT = "config.properties";
    public static String PROJECT_DIR = "app.project.dir";
    public static String DATASOURCE_UTIL_TABLES = "app.datasource.tables";
    public static String PRODUCTION = "app.production";

    public static Properties getProperties() {
        return getProperties(CONFIG_DEFAULT);
    }

    public static Properties getProperties(String path) {
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream(path);
            if (stream == null) return null;
            Properties properties = new Properties();
            properties.load(stream);
            stream.close();
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}