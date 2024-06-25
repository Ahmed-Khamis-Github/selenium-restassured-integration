package com.qacart.todo.utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.util.Properties;

public class ConfigUtils {
    private static ConfigUtils instance;
    private final Properties properties;

    private ConfigUtils() {
        String environment = System.getProperty("environment", "production");
        String propertiesFilePath;

        switch (environment) {
            case "production":
            default:
                propertiesFilePath = "src/test/java/com/qacart/todo/config/production.properties";
                break;
            case "local":

                propertiesFilePath = "src/test/java/com/qacart/todo/config/local.properties";
                break;
        }

        properties = PropertiesReader.readProperties(propertiesFilePath);    }

     public static ConfigUtils getInstance() {
        if (instance == null) {
            synchronized (ConfigUtils.class) {
                if (instance == null) {
                    instance = new ConfigUtils();
                }
            }
        }
        return instance;
    }

    public String getBaseUrl() {
        return properties.getProperty("base");
    }
    public String getEmail() {
        return properties.getProperty("email");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
