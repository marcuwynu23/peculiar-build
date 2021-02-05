package com.builder;

import java.util.ArrayList;
public class BatchRunner{

	private String terminal,fileName,appPath,workingPath,editorChoice,teminalColor;
	private String initialCmd = "cmd /K start";

	public void run(CommandLine cmdLine){
		try{
			terminal = cmdLine.getTerminal();
			fileName = cmdLine.getFileName();
			appPath = cmdLine.getApplicationPath();
			workingPath = cmdLine.getWorkingPath();
			editorChoice = cmdLine.getEditorChoice();
			teminalColor = cmdLine.getTerminalColor();		
	
			Runtime.getRuntime().exec(String.join(" ",initialCmd,terminal,fileName,appPath,workingPath,editorChoice,teminalColor));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}