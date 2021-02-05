
package com.peculiar.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;

public interface AppUIElements {
    void setUI(Border border,Font font,Color bColor,Color fcolor);
    void setUI(Font font,Color bColor,Color fcolor);
    void setUI(Border border,Color bColor,Color fcolor);
    void setUI(Color bColor,Color fcolor);
}
