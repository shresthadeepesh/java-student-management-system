/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.students;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentTable extends JFrame implements ActionListener {

    private final JButton addStudentButton;
    private final ViewButton viewButton;

    public StudentTable() {
        Container container = getContentPane();

        JLabel titleLabel = new JLabel("Student List");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setBounds(200, 50, 200, 30);
        container.add(titleLabel);

        addStudentButton = new JButton("Add Student");
        addStudentButton.setBounds(200, 100, 150, 20);
        addStudentButton.addActionListener(this);
        container.add(addStudentButton);

        JTable table = new JTable(this.mapStudentListToTable());
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setFont(new Font("Serif", Font.PLAIN, 15));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        viewButton = new ViewButton();
        table.getColumn("Actions").setCellRenderer(viewButton);

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

        List<Student> students = new StudentService().all();

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
        }
    }
}
