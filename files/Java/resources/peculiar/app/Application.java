package com.peculiar.app;

import com.peculiar.components.AppFrame;
import com.peculiar.components.AppLabel;
import com.peculiar.components.AppForm;
import java.awt.LayoutManager;

public abstract class Application extends AppFrame {
    public Application() {
        super();
        setFrameIcon("icon.jpg");
        super.setLocationRelativeTo(null);
    }
    public Application(AppLabel peculiarLabel) {
        setFramePane(peculiarLabel);
        setFrameIcon("icon.jpg");
        super.setLocationRelativeTo(null);

    }
    public Application(AppForm peculiarForm) {
        setFramePane(peculiarForm);
        setFrameIcon("icon.jpg");
        super.setLocationRelativeTo(null);

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
