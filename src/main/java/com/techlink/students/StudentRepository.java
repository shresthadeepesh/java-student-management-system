/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.students;

import com.techlink.database.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class StudentRepository {

    private final Connection connection;

    public StudentRepository() {
        connection = Connect.getConnection();
    }

    public List<Student> all() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = statement.executeQuery();

            students.addAll(this.mapToStudent(resultSet));

        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong, while fetching all students!");
            e.printStackTrace();
        }

        return students;
    }

    public Optional<Student> show(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Student> students = this.mapToStudent(resultSet);
            if (students.size() > 0) {
                return Optional.of(students.get(0));
            }
        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong, while fetching a students!");
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Student save(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students (name, email, address, grade, dob, phone, guardianName, gender, joinedAt, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getGrade());
            statement.setDate(5, new java.sql.Date(student.getDob().getTime()));
            statement.setString(6, student.getPhone());
            statement.setString(7, student.getGuardianName());
            statement.setString(8, "Male");
            statement.setDate(9, new java.sql.Date(student.getJoinedAt().getTime()));
            statement.setString(10, student.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong, while inserting a new student!");
            e.printStackTrace();
        }

        return student;
    }

    public Student update(int id, Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE students SET name = ?, email = ?, address = ?, grade = ?, dob = ?, phone = ?, guardianName = ?, gender = ?, joinedAt = ?, password = ? WHERE id = ?");
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getGrade());
            statement.setDate(5, new java.sql.Date(student.getDob().getTime()));
            statement.setString(6, student.getPhone());
            statement.setString(7, student.getGuardianName());
            statement.setString(8, "Male");
            statement.setDate(9, new java.sql.Date(student.getJoinedAt().getTime()));
            statement.setString(10, student.getPassword());
            statement.setInt(11, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong, while updating an existing student!");
            e.printStackTrace();
        }

        return student;
    }

    public Student delete(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM students WHERE id = ?");
            statement.setInt(1, student.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong, while deleting an existing student!");
            e.printStackTrace();
        }

        return student;
    }

    public Optional<Student> login(String email, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            List<Student> students = this.mapToStudent(resultSet);
            if (students.size() > 0) {
                return Optional.of(students.get(0));
            }
        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong, while logging the user!");
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Student register(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO students (name, email, address, grade, dob, phone, guardianName, gender, joinedAt, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, "N/A");
            statement.setString(4, "N/A");
            statement.setDate(5, java.sql.Date.valueOf("2021-01-01"));
            statement.setString(6, "N/A");
            statement.setString(7, "N/A");
            statement.setString(8, "Male");
            statement.setDate(9, java.sql.Date.valueOf("2021-01-01"));
            statement.setString(10, student.getPassword());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong, while updating an existing student!");
            e.printStackTrace();
        }

        return student;
    }

    public Student updatePassword(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE students SET password = ? WHERE id = ?");
            statement.setString(1, student.getPassword());
            statement.setInt(2, student.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong, while updating the user password!");
            e.printStackTrace();
        }

        return student;
    }

    public Optional<Student> findByEmail(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            List<Student> students = this.mapToStudent(resultSet);
            if (students.size() > 0) {
                return Optional.of(students.get(0));
            }
        } catch (SQLException e) {
            System.out.println("Oops! Something went wrong, while fetching the user!");
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private List<Student> mapToStudent(ResultSet resultSet) throws SQLException {
        List<Student> students = new ArrayList<>();

        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String address = resultSet.getString("address");
            String grade = resultSet.getString("grade");
            Date dob = resultSet.getDate("dob");
            String phone = resultSet.getString("phone");
            String guardianName = resultSet.getString("guardianName");
            String gender = resultSet.getString("gender");
            Date joinedAt = resultSet.getDate("joinedAt");
            Student student = new Student(id, name, email, password, address, grade, dob, phone, guardianName, gender, joinedAt);
            students.add(student);
        }

        return students;
    }


}
