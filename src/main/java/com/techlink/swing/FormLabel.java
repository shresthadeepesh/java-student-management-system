/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.swing;

import javax.swing.*;
import java.awt.*;

public class FormLabel extends JLabel {
    public FormLabel(String text) {
        super(text);
        setFont(new Font("Serif", Font.PLAIN, 15));
        setForeground(new Color(0, 0, 0));
    }
}
