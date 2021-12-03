/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.swing.students;

import com.techlink.common.students.Student;
import com.techlink.common.students.StudentService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentTable extends JFrame implements ActionListener {

    private final JButton addStudentButton, editButton, deleteButton, viewButton;
    private final JTable table;
    private final List<Student> students = new ArrayList<>();
    private int selectedId;
    private Student selectedStudent;
    private final StudentService studentService;

    public StudentTable() {
        studentService = new StudentService();

        students.addAll(studentService.all());
        Container container = getContentPane();

        JLabel titleLabel = new JLabel("Student List");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setBounds(200, 50, 200, 30);
        container.add(titleLabel);

        addStudentButton = new JButton("Add");
        addStudentButton.setBounds(200, 100, 100, 20);
        addStudentButton.addActionListener(this);
        container.add(addStudentButton);

        viewButton = new JButton("View");
        viewButton.setBounds(300, 100, 100, 20);
        viewButton.addActionListener(this);
        container.add(viewButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(400, 100, 100, 20);
        deleteButton.addActionListener(this);
        container.add(deleteButton);

        editButton = new JButton("Edit");
        editButton.setBounds(500, 100, 100, 20);
        editButton.addActionListener(this);
        container.add(editButton);

        table = new JTable(this.mapStudentListToTable());
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setFont(new Font("Serif", Font.PLAIN, 15));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedId = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                selectedStudent = students.get(selectedId - 1);
            }
        });

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(30, 150, 600, 500);

        container.add(pane);

        setLayout(null);
        setSize(800, 800);
        setTitle("Students Table");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#DBDBDB"));
    }

    private DefaultTableModel mapStudentListToTable() {
        String[] column = {"", "Name", "Grade", "Address", "Phone", "Actions"};

        String[][] data = new String[students.size()][5];

        for (Student s: students) {
            data[students.indexOf(s)][0] = String.valueOf(students.indexOf(s) + 1);
            data[students.indexOf(s)][1] = s.getName();
            data[students.indexOf(s)][2] = s.getGrade();
            data[students.indexOf(s)][3] = s.getAddress();
            data[students.indexOf(s)][4] = s.getPhone();
        }

        return new DefaultTableModel(data, column);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addStudentButton) {
            new StudentForm();
        } else if(e.getSource() == deleteButton) {
            studentService.delete(selectedStudent);
            JOptionPane.showMessageDialog(null, "Student has been deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            students.remove(selectedId - 1);
        } else if(e.getSource() == viewButton) {
            new ViewStudent(selectedStudent.getId());
        }
    }
}
