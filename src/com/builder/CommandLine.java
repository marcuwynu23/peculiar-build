package com.builder;

public class CommandLine{

	private String terminal,fileName,appPath,workingPath,editorChoice,terminalColor;

	public CommandLine(String fileName,CommandConfig config){
			this.fileName = fileName;
			terminal = config.getTerminal();
			appPath = config.getAppPath();
			workingPath = config.getWorkingPath();
			editorChoice = config.getEditorChoice();
			terminalColor = config.getTerminalColor();
	}
	public String getTerminal(){ return this.terminal; }
	public void setTerminal(String terminal){ this.terminal=terminal; }
	public String getFileName(){ return this.fileName; }
	public void setFileName(String fileName){ this.fileName=fileName; }

	public String getApplicationPath(){ return this.appPath; }
	public void getApplicationPath(String appPath){ this.appPath=appPath; }

	public String getWorkingPath(){ return this.workingPath; }
	public void setWorkingPath(String workingPath){ this.workingPath=workingPath; }

	public String getEditorChoice(){ return this.editorChoice; }
	public void setEditorChoice(String editorChoice){ this.editorChoice=editorChoice; }

	public String getTerminalColor(){ return this.terminalColor; }
	public void setTerminalColor(String terminalColor){ this.terminalColor=terminalColor; }
}