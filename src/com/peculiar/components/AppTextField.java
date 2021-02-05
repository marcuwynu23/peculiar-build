package com.peculiar.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AppTextField extends JTextField implements AppUIElements {
    public AppTextField(int col) {
        super(col);
    }
    public void setUI(Border border, Font font, Color bColor, Color fcolor) {
        setBorder(border);
        setFont(font);
        setBackground(bColor);
        setForeground(fcolor);
    }
    @Override
    public void setUI(Font font, Color bColor, Color fcolor) {
        setFont(font);
        setBackground(bColor);
        setForeground(fcolor);
    }
    @Override
    public void setUI(Border border, Color bColor, Color fcolor) {
        setBorder(border);
        setBackground(bColor);
        setForeground(fcolor);
    }
    @Override
    public void setUI(Color bColor, Color fcolor) {
        setBackground(bColor);
        setForeground(fcolor);
    }
    
}
