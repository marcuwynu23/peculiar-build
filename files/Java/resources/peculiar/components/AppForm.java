
package com.peculiar.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class AppForm extends JPanel implements AppUIElements{
    
    public AppForm(){
        super();
    }
    public void setFormSize(int width,int height){
        super.setPreferredSize(new Dimension(width, height));
    }
   
    public void setUI(Font font, Color bColor, Color fcolor) {
        setFont(font);
        setBackground(bColor);
        setForeground(fcolor);
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
}
