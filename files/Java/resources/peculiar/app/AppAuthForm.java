package com.peculiar.app;

import com.peculiar.constants.AppStrings;
import com.peculiar.app.auth.UserModel;
import com.peculiar.app.initial.ContentPane;
import com.peculiar.components.AppButton;
import com.peculiar.components.AppLabel;
import com.peculiar.constants.AppColor;
import com.peculiar.constants.AppDefault;
import com.peculiar.constants.AppFont;
import com.peculiar.constants.AppLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public final class AppAuthForm extends Application implements SetApp {
    private AppStrings str = new AppStrings();
    public AppLabel titleLabel;
    public AppButton loginBtn;
    public AppButton registerBtn;
    public AppButton recoveryBtn;
    public AppButton submitBtn;
    public AppButton saveBtn;

    private AppLoginForm loginForm;
    private AppRegisterForm registerForm;
    private AppRecoveryForm recoveryForm;
    private ArrayList<UserModel> database;

//Main form for User Authentication
    public AppAuthForm() {
        super(new ContentPane());
        database = new ArrayList<UserModel>();
        setAppInit();
        setAppComponents();
        setAppConstraints();
        setAppUI();
    }
    public void setAppInit() {
        setAppSize(AppDefault.WIDTH, AppDefault.HEIGHT);
        setAppResizable(false);
        setAppLayout(AppLayout.GRIDBAG);
    }

    public void setAppComponents() {
        titleLabel = new AppLabel(str.AUTH[0]);
        loginBtn = new AppButton(str.AUTH[1]);
        recoveryBtn = new AppButton(str.AUTH[2]);
        registerBtn = new AppButton(str.AUTH[3]);

        loginForm = new AppLoginForm();
        submitBtn = loginForm.getSubmitBtn();
        registerForm = new AppRegisterForm();
        saveBtn = registerForm.getSaveBtn();
        recoveryForm = new AppRecoveryForm();

    }

    public void setAppUI() {
        titleLabel.setUI(AppFont.TITLE_FONT, AppColor.SECONDARY, AppColor.TRITIARY);
        loginBtn.setUI(AppFont.MEDIUM_FONT, AppColor.TRITIARY, Color.white);
        registerBtn.setUI(AppFont.MEDIUM_FONT, AppColor.TRITIARY, Color.white);
        recoveryBtn.setUI(AppFont.SMALL_FONT, Color.WHITE, Color.BLACK);
        
        loginBtn.setButtonSize(150, 50);
        registerBtn.setButtonSize(150, 50);
    }
    public void setAppAction() {

    }
    private void setAppConstraints() {
        var gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 5, 20, 5);
        add(titleLabel, gc);
        gc.gridx = 0;
        gc.gridy++;
        gc.insets = new Insets(20, 5, 10, 5);
        add(loginBtn, gc);
        gc.gridx = 0;
        gc.gridy++;
        gc.insets = new Insets(10, 5, 10, 5);
        add(registerBtn, gc);
        gc.gridy++;
        gc.insets = new Insets(10, 5, 10, 5);
        add(recoveryBtn, gc);

    }
    public void setAuthenticate(Application app, ArrayList<UserModel> database) {
        this.database = database;
        loginBtn.addAction(e -> loginBtnAction());
        registerBtn.addAction(e -> registerBtnAction());
        recoveryBtn.addAction(e -> recoveryBtnAction());
        submitBtn.addAction(e -> submitBtnAction(app));
        saveBtn.addAction(e -> saveBtnAction());
    }

    private void loginBtnAction() {
        loginForm.showApp();
        hideApp();
    }
    private void registerBtnAction() {
        //need user data here
        registerForm.showApp();
        hideApp();
    }
    private void recoveryBtnAction() {
        //need user data here
        recoveryForm.showApp();
        this.hideApp();
    }
    private void submitBtnAction(Application app) {
        //need user data here
        loginForm.hideApp();
        app.showApp();
    }
    private void saveBtnAction() {
        //need user data here
        JOptionPane.showMessageDialog(null, str.AUTH[4]);
        registerForm.hideApp();
        showApp();
    }
}
