/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peculiar.app;

import com.peculiar.constants.AppStrings;
import com.peculiar.app.initial.ContentPane;
import com.peculiar.components.AppButton;
import com.peculiar.constants.AppColor;
import com.peculiar.constants.AppDefault;
import com.peculiar.constants.AppLayout;
import java.awt.GridBagConstraints;

/**
 *
 * @author admin
 */
class AppRegisterForm extends Application implements SetApp{
    private AppStrings str = new AppStrings();
    private AppButton saveBtn;

    public AppRegisterForm() {
        super(new ContentPane());
       setAppInit();
        setAppComponents();
        setAppUI();
    }
     
    public void setAppInit() {
        setAppTitle(str.REGISTER[0]);
        setAppSize(AppDefault.WIDTH, AppDefault.HEIGHT);
        setAppResizable(false);
        setAppLayout(AppLayout.GRIDBAG);
    }

    public void setAppComponents() {
        saveBtn = new AppButton(str.REGISTER[1]);

        var gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        add(saveBtn, gc);
    }

    public void setAppUI() {
        saveBtn.setUI(new java.awt.Color(11, 19, 201), AppColor.PRIMARY);
    }

    public AppButton getSaveBtn() {
        return saveBtn;
    }
   public void setAppAction() {
    }
}
