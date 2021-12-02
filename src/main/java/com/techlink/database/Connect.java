/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private Connection connection;

    public Connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student-management", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
