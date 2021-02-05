package com.peculiar.components;

import com.peculiar.constants.AppDefault;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AppFrame extends JFrame {
    public AppFrame() {
        setInit();
    }
    private void setInit() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        super.setSize(AppDefault.WIDTH, AppDefault.HEIGHT);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(3);
        super.setVisible(false);
    }

    public void setAppLooks(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }
    public void setFramePane(Container container){
        setContentPane(container);
    }
    public void setFrameIcon(String iconURL) {
        super.setIconImage(new ImageIcon(iconURL).getImage());
    }
    public void showFrame() {
        super.setVisible(true);
    }
    public void hideFrame() {
        super.setVisible(false);
    }
    public void setFrameSize(int width, int height) {
        super.setSize(width, height);
    }

}
