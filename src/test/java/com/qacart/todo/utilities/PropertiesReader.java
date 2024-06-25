package com.qacart.todo.utilities;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {

    public static Properties readProperties(String filePath) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(filePath)) {
            prop.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read properties file: " + filePath, e);
        }
        return prop;
    }
}
