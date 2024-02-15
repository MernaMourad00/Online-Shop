package org.example.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFiles {
    public Properties ConfigFileProp(){
        String configFile = "D:\\Design Patterns Labs\\E-CommerceApp\\src\\main\\resources\\configuration\\config.properties";

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(configFile)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("Error reading the properties file: " + e.getMessage());
        }
        return properties;
    }
}
