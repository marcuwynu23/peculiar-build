package view;

import builder.BatchRunner;
import builder.CommandLine;
import builder.ConfigLoader;
import com.peculiar.app.Application;
import com.peculiar.app.SetApp;
import com.peculiar.components.AppButton;
import com.peculiar.components.AppLabel;
import com.peculiar.components.AppPanel;
import com.peculiar.components.AppHover;
import com.peculiar.constants.AppLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class View extends Application implements SetApp {

    private final Constants constant = new Constants();

    private AppPanel titlePnl, mainPnl, menuBar;
    private AppLabel titleLbl, subtitleLbl;

    private AppButton javaBtn;
    private AppButton pythonBtn;
    private AppButton jythonBtn;
    private AppButton djangoBtn;
    private AppButton kotlinBtn;
    private AppButton nodeJSBtn;
    private AppButton toolBuildBtn;
    private AppButton cSharpBtn;
    private AppButton webBtn;
    private AppButton pecConfigBtn;

    private ConfigurationDialog configDialog;
    public View() {
        setApp();
    }
    private void setApp() {
        setAppInit();
        setAppComponents();
        setAppUI();
        setAppListener();
    }
    public void setAppInit() {
        setAppTitle(constant.APP_TITLE);
        setAppIcon(constant.APP_ICON_PATH);
        setAppSize(constant.APP_WIDTH, constant.APP_HEIGHT);
        setMinimumSize(new java.awt.Dimension(constant.APP_WIDTH, constant.APP_HEIGHT));
        setAppCenterOnScreen();
        setAppLayout(AppLayout.BORDER);
    }
    public void setAppComponents() {
        setTitlePnl();
        setMainPnl();
        setMenuBar();

    }
    private void setTitlePnl() {
        titlePnl = new AppPanel();
        titlePnl.setPanelSize(constant.APP_WIDTH, 150);
        titlePnl.setLayout(AppLayout.FLOW_CENTER);
        titleLbl = new AppLabel(constant.APP_STRINGS[0]);
        subtitleLbl = new AppLabel(constant.APP_STRINGS[1]);
        titlePnl.add(titleLbl);
        titlePnl.add(subtitleLbl);
        add(titlePnl, AppLayout.BORDER_NORTH);
    }
    private void setMainPnl() {
        mainPnl = new AppPanel();
        mainPnl.setLayout(AppLayout.GRIDBAG);
        javaBtn = new AppButton(constant.APP_STRINGS[2]);
        pythonBtn = new AppButton(constant.APP_STRINGS[3]);
        jythonBtn = new AppButton(constant.APP_STRINGS[4]);
        djangoBtn = new AppButton(constant.APP_STRINGS[5]);
        kotlinBtn = new AppButton(constant.APP_STRINGS[6]);
        nodeJSBtn = new AppButton(constant.APP_STRINGS[7]);
        cSharpBtn = new AppButton(constant.APP_STRINGS[19]);
        webBtn = new AppButton(constant.APP_STRINGS[20]);
        toolBuildBtn = new AppButton(constant.APP_STRINGS[8]);

        var gc = new GridBagConstraints();
        gc.weighty = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(4, 4, 4, 4);
        gc.gridx = 0;
        gc.gridy = 0;
        mainPnl.add(javaBtn, gc);
        gc.gridx = 1;
        mainPnl.add(pythonBtn, gc);
        gc.gridx = 2;
        mainPnl.add(jythonBtn, gc);
        gc.gridx = 0;
        gc.gridy++;
        mainPnl.add(djangoBtn, gc);
        gc.gridx = 1;
        mainPnl.add(kotlinBtn, gc);
        gc.gridx = 2;
        mainPnl.add(nodeJSBtn, gc);
        gc.gridx = 0;
        gc.gridy++;
        mainPnl.add(toolBuildBtn, gc);
        gc.gridx = 1;
        mainPnl.add(cSharpBtn, gc);
        gc.gridx = 2;
        mainPnl.add(webBtn, gc);

        add(mainPnl, AppLayout.BORDER_CENTER);
    }
    private void setMenuBar() {
        menuBar = new AppPanel();
        menuBar.setLayout(AppLayout.FLOW_LEFT);
        pecConfigBtn = new AppButton(constant.APP_STRINGS[9]);
        menuBar.add(pecConfigBtn);
        add(menuBar, AppLayout.BORDER_SOUTH);
    }

    public void setAppUI() {

        titlePnl.setBackground(constant.X_COLOR);
        mainPnl.setBackground(constant.T_COLOR);
        menuBar.setBackground(constant.X_COLOR);

        titlePnl.setBorder(constant.APP_BORDER);
        titlePnl.setBorder(constant.APP_BORDER);
        mainPnl.setBorder(constant.APP_BORDER);

        titleLbl.setUI(constant.B_FONT, constant.T_COLOR, constant.T_COLOR);
        subtitleLbl.setUI(new Font(constant.FONT, 1, 12), constant.S_COLOR, constant.S_COLOR);

        javaBtn.setUI(constant.APP_BORDER, constant.M_FONT1, constant.X_COLOR, constant.S_COLOR);
        pythonBtn.setUI(constant.APP_BORDER, constant.M_FONT1, constant.X_COLOR, constant.S_COLOR);
        jythonBtn.setUI(constant.APP_BORDER, constant.M_FONT1, constant.X_COLOR, constant.S_COLOR);
        djangoBtn.setUI(constant.APP_BORDER, constant.M_FONT1, constant.X_COLOR, constant.S_COLOR);
        kotlinBtn.setUI(constant.APP_BORDER, constant.M_FONT1, constant.X_COLOR, constant.S_COLOR);
        nodeJSBtn.setUI(constant.APP_BORDER, constant.M_FONT1, constant.X_COLOR, constant.S_COLOR);
        toolBuildBtn.setUI(constant.APP_BORDER, constant.M_FONT1, constant.X_COLOR, constant.S_COLOR);
        cSharpBtn.setUI(constant.APP_BORDER, constant.M_FONT1, constant.X_COLOR, constant.S_COLOR);
        webBtn.setUI(constant.APP_BORDER, constant.M_FONT1, constant.X_COLOR, constant.S_COLOR);

        javaBtn.addMouseListener(AppHover.getInstance(javaBtn, constant.X_COLOR, constant.S_COLOR));
        pythonBtn.addMouseListener(AppHover.getInstance(pythonBtn, constant.X_COLOR, constant.S_COLOR));
        jythonBtn.addMouseListener(AppHover.getInstance(jythonBtn, constant.X_COLOR, constant.S_COLOR));
        djangoBtn.addMouseListener(AppHover.getInstance(djangoBtn, constant.X_COLOR, constant.S_COLOR));
        kotlinBtn.addMouseListener(AppHover.getInstance(kotlinBtn, constant.X_COLOR, constant.S_COLOR));
        nodeJSBtn.addMouseListener(AppHover.getInstance(nodeJSBtn, constant.X_COLOR, constant.S_COLOR));
        toolBuildBtn.addMouseListener(AppHover.getInstance(toolBuildBtn, constant.X_COLOR, constant.S_COLOR));
        cSharpBtn.addMouseListener(AppHover.getInstance(cSharpBtn, constant.X_COLOR, constant.S_COLOR));
        webBtn.addMouseListener(AppHover.getInstance(webBtn, constant.X_COLOR, constant.S_COLOR));

        pecConfigBtn.setUI(constant.S_FONT, constant.X_COLOR, constant.T_COLOR);

        javaBtn.setButtonSize(250, 80);
        pythonBtn.setButtonSize(250, 80);
        jythonBtn.setButtonSize(250, 80);

        djangoBtn.setButtonSize(250, 80);
        kotlinBtn.setButtonSize(250, 80);
        nodeJSBtn.setButtonSize(250, 80);

        toolBuildBtn.setButtonSize(250, 80);
        cSharpBtn.setButtonSize(250, 80);
        webBtn.setButtonSize(250, 80);

    }
    public void setAppListener() {

        var bRunner = new BatchRunner();
        configDialog = new ConfigurationDialog();
        var configloader = new ConfigLoader();
        configDialog.setLoader(configloader);
        configDialog.showConfig();

        javaBtn.addActionListener(e -> bRunner.run(new CommandLine(constant.BATCH_FILE[0], configloader.getConfiguration())));
        pythonBtn.addActionListener(e -> bRunner.run(new CommandLine(constant.BATCH_FILE[1], configloader.getConfiguration())));
        jythonBtn.addActionListener(e -> bRunner.run(new CommandLine(constant.BATCH_FILE[2], configloader.getConfiguration())));
        djangoBtn.addActionListener(e -> bRunner.run(new CommandLine(constant.BATCH_FILE[3], configloader.getConfiguration())));
        kotlinBtn.addActionListener(e -> bRunner.run(new CommandLine(constant.BATCH_FILE[4], configloader.getConfiguration())));
        nodeJSBtn.addActionListener(e -> bRunner.run(new CommandLine(constant.BATCH_FILE[5], configloader.getConfiguration())));
        toolBuildBtn.addActionListener(e -> bRunner.run(new CommandLine(constant.BATCH_FILE[6], configloader.getConfiguration())));
        cSharpBtn.addActionListener(e -> bRunner.run(new CommandLine(constant.BATCH_FILE[7], configloader.getConfiguration())));
        webBtn.addActionListener(e -> bRunner.run(new CommandLine(constant.BATCH_FILE[8], configloader.getConfiguration())));
        pecConfigBtn.addActionListener(e -> {
            configDialog.showDialog();
        });
    }
}
