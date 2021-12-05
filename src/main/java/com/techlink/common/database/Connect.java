/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.common.database;

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, user, password);
            System.out.println("Database has been connected successfully.");
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
