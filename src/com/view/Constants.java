package com.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.UIManager;
import javax.swing.BorderFactory;

public class Constants {
    public final String APP_ICON_PATH = "res/img/peculiar-project-builder.png";
    public final String APP_TITLE = "Peculiar Project Build version 0.0.1";
    public final String APP_LOOK_AND_FEEL = UIManager.getSystemLookAndFeelClassName();
    public final int APP_WIDTH = 900;
    public final int APP_HEIGHT = 600;
 
    public final Border APP_BORDER = BorderFactory.createEtchedBorder();

    public final Color P_COLOR = new Color(25, 25, 25);
    public final Color S_COLOR = Color.WHITE;
    public final Color T_COLOR = Color.GREEN;
    public final Color X_COLOR = new Color(16, 16, 16);

//    public final String FONT = "Roboto Condensed"; 
    public final String FONT = "Roboto";
    public final Font B_FONT = new Font(FONT, 1, 90);
    public final Font N_FONT = new Font(FONT, 1, 20);

    public final Font M_FONT = new Font(FONT, 0, 16);
    public final Font M_FONT1 = new Font(FONT, 1, 22);
    public final Font M_FONT2 = new Font(FONT, 1, 16);

    public final Font S_FONT = new Font(FONT, 1, 12);
    public final Font BTN_FONT = new Font(FONT, 1, 14);

    public final String[] APP_STRINGS = {
        "Project Build",
        "version 0.0.1",
        "Java",
        "Python",
        "Jython(experimental)",
        "Django(experimental)",
        "Kotlin(experimental)",
        "NodeJS",
        "ToolBuild(experimental)",
        "Configuration Settings",
        "About",
        "Terminal",
        "Application File Path",
        "Working Path",
        "Editor Choice",
        "Terminal Color",
        "Save",
        "Select",
        "Build Configuration",
        "C#(experimental)",};
    
    
    
    protected  static final String[] CONF_DIALOG_STR = {
    "Configuratiom Settings",
        "Choose Application Files Path: ",
        "Choose Working Directory: ",
        "Peculiar"
    };
    public final int[] APP_DIGITS = {
        20,};
    public final String[] BATCH_FILE = {
        "files\\java_auto.bat",
        "files\\python_auto.bat",
        "files\\jython_auto.bat",
        "files\\django_auto.bat",
        "files\\kotlin_auto.bat",
        "files\\nodejs_auto.bat",
        "files\\toolbuild_auto.bat",
        "files\\csharpbuild_auto.bat"
    };

}
