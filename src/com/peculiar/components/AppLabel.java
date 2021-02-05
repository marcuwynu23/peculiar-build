package com.peculiar.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class AppLabel extends JLabel implements AppUIElements {

    public AppLabel() {
        super();
    }
    public AppLabel(String text) {
        super(text);
    }
     public AppLabel(String imgURL, int width, int height, int scale) {
        var image = new ImageIcon(imgURL).getImage();
        var icon = image.getScaledInstance(width, height, scale);
        setIcon(new ImageIcon(icon));

    }
    
    public void setImage(String imgURL, int width, int height, int scale) {
        var image = new ImageIcon(imgURL).getImage();
        var icon = image.getScaledInstance(width, height, scale);
        setIcon(new ImageIcon(icon));

    }
  
    public void setUI(Font font, Color bColor, Color fcolor) {
        setFont(font);
        setForeground(fcolor);
        setBackground(bColor);
    }
    public void setUI(Color bColor, Color fcolor) {
        setBackground(bColor);
        setForeground(fcolor);
    }
     public void setUI(Border border, Font font, Color bColor, Color fcolor) {
        setBorder(border);
        setFont(font);
        setBackground(bColor);
        setForeground(fcolor);
    }
  
    public void setUI(Border border, Color bColor, Color fcolor) {
         setBorder(border);
        setBackground(bColor);
        setForeground(fcolor);
    }
    public void setLabelSize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }
}
