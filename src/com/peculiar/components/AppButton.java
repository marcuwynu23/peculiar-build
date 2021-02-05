package com.peculiar.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class AppButton extends JButton implements AppUIElements {
    public AppButton() {
        setBorderPainted(false);
    }
    public AppButton(String text) {
        super(text);
        setBorderPainted(false);
    }
    public AppButton(String image_URL, int width, int height, int scale) {
        var image = new ImageIcon(image_URL).getImage();
        var icon = image.getScaledInstance(width, height, scale);
        setIcon(new ImageIcon(icon));
        setBorderPainted(false);
    }
    public void setButtonSize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }
    public void setUI(Font font, Color bColor, Color fcolor) {
        setFont(font);
        setForeground(fcolor);
        setBackground(bColor);
    }
    @Override
     public void setUI(Color bColor, Color fcolor) {
        setBackground(bColor);
        setForeground(fcolor);
    }
    @Override
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
}
