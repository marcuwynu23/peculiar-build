package com.peculiar.app;

import com.peculiar.app.auth.UserModel;
import com.peculiar.app.initial.ContentPane;
import com.peculiar.components.AppButton;
import com.peculiar.components.AppLabel;
import com.peculiar.constants.AppColor;
import com.peculiar.constants.AppDefault;
import com.peculiar.constants.AppLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public final class AppAuthForm extends Application implements SetApp{
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
        titleLabel = new AppLabel("Authentication Form");
        loginBtn = new AppButton("login");
        recoveryBtn = new AppButton("forgot password?");
        registerBtn = new AppButton("register");

        loginForm = new AppLoginForm();
        submitBtn = loginForm.getSubmitBtn();
        registerForm = new AppRegisterForm();
        saveBtn = registerForm.getSaveBtn();
        recoveryForm = new AppRecoveryForm();

    }

    public void setAppUI() {
        loginBtn.setButtonSize(200, 50);
        registerBtn.setButtonSize(200, 50);
        titleLabel.setUI(new java.awt.Font("Candara", 1, 50), AppColor.PRIMARY, new java.awt.Color(11, 19, 201));
        loginBtn.setUI(new java.awt.Font("Candara", 1, 23), new java.awt.Color(11, 19, 201), AppColor.PRIMARY);
        registerBtn.setUI(new java.awt.Font("Candara", 1, 23), new java.awt.Color(11, 19, 201), AppColor.PRIMARY);
    }
    public void setAppListener() {

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
    }
    public void setAuthenticate(Application app, ArrayList<UserModel> database) {
        this.database = database;
        loginBtn.addActionListener(e -> loginBtnAction());
        registerBtn.addActionListener(e -> registerBtnAction());
        recoveryBtn.addActionListener(e -> recoveryBtnAction());
        submitBtn.addActionListener(e -> submitBtnAction(app));
        saveBtn.addActionListener(e -> saveBtnAction());
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
        JOptionPane.showMessageDialog(null, "your account are successfully register!");
        registerForm.hideApp();
        showApp();
    }
}
