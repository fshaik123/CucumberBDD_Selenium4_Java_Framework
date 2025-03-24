package com.util.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String propertyName) throws IOException {
        Properties prop = new Properties();
        String propertyValue = "";
        try (InputStream input = com.util.ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new FileNotFoundException("config.properties file not found in classpath");
            }
            prop.load(input);
            propertyValue = prop.getProperty(propertyName);
            if (propertyValue == null) {
                System.err.println("Warning: Property '" + propertyName + "' not found in config.properties");
                propertyValue = ""; // Return empty string if property not found
            }
        } catch (IOException e) {
            System.err.println("Error reading config.properties: " + e.getMessage());
            throw e; // Re-throw the exception after logging
        }
        return propertyValue;
    }
}