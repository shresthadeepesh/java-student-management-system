/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static Connection connection;

     static {
         String url = "jdbc:mysql://localhost:3306";
         String dbName = "student-management";
         String user = "root";
         String password = "";
         String connectionUrl = String.format("%s/%s", url,  dbName);

        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
            System.out.println("Database has been connected successfully.");
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
