package org.example;

import org.example.configuration.ReadConfigFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    private static DbConnection instance;
    private Connection connection;

    private DbConnection() {

        String url;
        String username;
        String password;

        ReadConfigFiles configFile= new ReadConfigFiles();



        Properties prop = configFile.ConfigFileProp();

        if (prop != null) {

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            System.out.println("Database URL: " + url);
            System.out.println("Database Username: " + username);
            System.out.println("Database Password: " + password);

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.err.println("Error creating database connection: " + e.getMessage());
            }
        }
    }

    public static synchronized DbConnection getInstance() {
        if (instance == null) {
            synchronized (DbConnection.class) {
                if (instance == null) {
                    instance = new DbConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }


}
