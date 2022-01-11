
package view;

import builder.ConfigLoader;
import com.peculiar.components.AppButton;
import com.peculiar.components.AppDialog;
import com.peculiar.components.AppLabel;
import com.peculiar.components.AppTextField;
import com.peculiar.constants.AppLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import javax.swing.JFileChooser;
import com.peculiar.app.SetApp;
import com.peculiar.app.initial.ContentPane;



public class ConfigurationDialog extends AppDialog implements SetApp{
	
	private Constants constants = new Constants();
	private ConfigLoader loader;
	private String terminal,appPath,workingPath,editorChoice,terminalColor;

	private AppLabel titleLbl;
	private AppTextField terminalFld,appPathFld,workingPathFld,editorChoiceFld,terminalColorFld;
	private AppLabel terminalLbl,appPathLbl,workingPathLbl,editorChoiceLbl,terminalColorLbl;
	private AppButton appPathBtn,workingPathBtn;

	private AppButton saveBtn;
	public ConfigurationDialog(){
		SetApp();
	}
	private void SetApp(){
		setAppInit();
		setAppComponents();
		setAppUI();
		setAppListener();
	}
	public void setAppInit(){
		setTitle(Constants.CONF_DIALOG_STR[0]);
		setDialogSize(constants.APP_WIDTH-100,constants.APP_HEIGHT-230);
		setDialogIcon(constants.APP_ICON_PATH);
		setDialogCenterOnScreen();
		setResizable(false);
                setContentPane(new ContentPane());
                setLayout(AppLayout.GRIDBAG);
                
	}
	public void setAppComponents(){

		titleLbl = new AppLabel(constants.APP_STRINGS[18]);

		terminalLbl  = new AppLabel(constants.APP_STRINGS[11]);
		appPathLbl  = new AppLabel(constants.APP_STRINGS[12]);
		workingPathLbl = new AppLabel(constants.APP_STRINGS[13]);
		editorChoiceLbl  = new AppLabel(constants.APP_STRINGS[14]);
		terminalColorLbl = new AppLabel(constants.APP_STRINGS[15]);

		terminalFld  = new AppTextField(constants.APP_DIGITS[0]);
		appPathFld  = new AppTextField(constants.APP_DIGITS[0]);
		workingPathFld  = new AppTextField(constants.APP_DIGITS[0]);
		editorChoiceFld  = new AppTextField(constants.APP_DIGITS[0]);
		terminalColorFld = new AppTextField(constants.APP_DIGITS[0]);

		appPathBtn = new AppButton(constants.APP_STRINGS[17]);
		workingPathBtn = new AppButton(constants.APP_STRINGS[17]);
		

		saveBtn = new AppButton(constants.APP_STRINGS[16]);
		var gc = new GridBagConstraints();
      		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(12,4,12,4);
		gc.weightx = 0;
		gc.gridy = 0;add(titleLbl,gc);
		
		gc.insets = new Insets(4,4,4,4);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;add(terminalLbl,gc);
		gc.gridx = 1;add(terminalFld,gc);

		gc.gridy++;
		gc.gridx=0;add(appPathLbl,gc);
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx=1;add(appPathFld,gc);
		gc.gridx=2;add(appPathBtn,gc);
		
		gc.gridy++;
		gc.gridx=0;add(workingPathLbl,gc);
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx=1; add(workingPathFld,gc);
		gc.gridx=2; add(workingPathBtn,gc);
		
		gc.gridy++;
		gc.gridx=0;add(editorChoiceLbl,gc);
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx=1; add(editorChoiceFld,gc);
		
		gc.gridy++;
		gc.gridx=0;add(terminalColorLbl,gc);
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx=1; add(terminalColorFld,gc);

		gc.gridy++;
		gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5,4,5,4);
		gc.gridx=1;
                add(saveBtn,gc);
	}

	public void setAppUI(){
		titleLbl.setFont(constants.N_FONT);
		terminalFld.setUI(constants.M_FONT,constants.S_COLOR,constants.P_COLOR);
		appPathFld.setUI(constants.M_FONT,constants.S_COLOR,constants.P_COLOR);
		workingPathFld.setUI(constants.M_FONT,constants.S_COLOR,constants.P_COLOR);
		editorChoiceFld.setUI(constants.M_FONT,constants.S_COLOR,constants.P_COLOR);
		terminalColorFld.setUI(constants.M_FONT,constants.S_COLOR,constants.P_COLOR);


		terminalLbl.setUI(constants.M_FONT2,constants.S_COLOR,constants.P_COLOR);
		appPathLbl.setUI(constants.M_FONT2,constants.S_COLOR,constants.P_COLOR);
		workingPathLbl.setUI(constants.M_FONT2,constants.S_COLOR,constants.P_COLOR);
		editorChoiceLbl.setUI(constants.M_FONT2,constants.S_COLOR,constants.P_COLOR);
		terminalColorLbl.setUI(constants.M_FONT2,constants.S_COLOR,constants.P_COLOR);

		appPathBtn.setUI(constants.M_FONT2,constants.P_COLOR,constants.S_COLOR);
		workingPathBtn.setUI(constants.M_FONT2,constants.P_COLOR,constants.S_COLOR);

		saveBtn.setUI(constants.BTN_FONT,constants.P_COLOR,constants.S_COLOR);
	}
	public void setAppListener(){	
		var fileChooser = new JFileChooser();
		appPathBtn.addActionListener(e->{
			fileChooser.setDialogTitle(Constants.CONF_DIALOG_STR[1]);
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.showOpenDialog(this);
			appPath = fileChooser.getSelectedFile().toString();
		});
		workingPathBtn.addActionListener(e->{
			fileChooser.setDialogTitle(Constants.CONF_DIALOG_STR[2]);
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.showOpenDialog(this);
			var workingDirectory = fileChooser.getSelectedFile().toString() + "\\"+Constants.CONF_DIALOG_STR[3];
			workingPath = workingDirectory;
		});
		saveBtn.addActionListener(e->{
			terminal = terminalFld.getText();
			editorChoice = editorChoiceFld.getText();
			terminalColor = terminalColorFld.getText();
			var cmdArray = new String[]{terminal,appPath,workingPath,editorChoice,terminalColor};
			loader.changeConfig(cmdArray);
		});
		
	}	

	public void showConfig(){
		var cmdArray = loader.getConfig();
		terminal = cmdArray[0];
		appPath = cmdArray[1];
		workingPath = cmdArray[2];
		editorChoice = cmdArray[3];
		terminalColor = cmdArray[4];

		terminalFld.setText(terminal);
		appPathFld.setText(appPath);
		workingPathFld.setText(workingPath);
		editorChoiceFld.setText(editorChoice);
		terminalColorFld.setText(terminalColor);		
	}
	public void setLoader(ConfigLoader loader){
		this.loader = loader;
	}

}