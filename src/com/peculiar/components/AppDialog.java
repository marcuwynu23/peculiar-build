package com.peculiar.components;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AppDialog extends JDialog {
    public AppDialog() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    public void setLookAndFeel(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }
    public void setDialogSize(int width, int height) {
        super.setSize(width, height);
    }
    public void setDialogIcon(String iconURL) {
        super.setIconImage(new ImageIcon(iconURL).getImage());
    }
    public void setDialogCenterOnScreen() {
        super.setLocationRelativeTo(null);
    }
    public void showDialog() {
        super.setVisible(true);
    }
    public void hideDialog() {
        super.setVisible(false);
    }

}
