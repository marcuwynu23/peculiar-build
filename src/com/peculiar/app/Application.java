package com.peculiar.app;

import com.peculiar.components.AppFrame;
import com.peculiar.components.AppLabel;
import com.peculiar.components.AppPanel;
import java.awt.LayoutManager;

public class Application extends AppFrame {
    public Application() {
        super();
    }
    public Application(AppLabel peculiarLabel) {
        setFramePane(peculiarLabel);
    }
    public Application(AppPanel peculiarPanel) {
        setFramePane(peculiarPanel);
    }

    public void setAppFullSize() {
        super.setExtendedState(6);
    }
   public void setAppTitle(String title){
       super.setTitle(title);
   }
    public void setAppSize(int width, int height) {
        super.setFrameSize(width, height);
    }
    public void setAppCenterOnScreen() {
        super.setLocationRelativeTo(null);
    }

    public void setAppIcon(String iconURL) {
        super.setFrameIcon(iconURL);
    }
    public void setAppResizable(boolean isResizable) {
        super.setResizable(isResizable);
    }
    public void setAppLayout(LayoutManager layout) {
        super.setLayout(layout);
    }
    public void showApp() {
        super.showFrame();
    }
    public void hideApp() {
        super.hideFrame();
    }
   
}
