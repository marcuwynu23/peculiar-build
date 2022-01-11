package builder;



public class CommandConfig{
	
	private String terminal;
	private String appPath;
	private String workingPath;
	private String editorChoice;
	private String terminalColor;

	public CommandConfig(String... cmdConfigArray){
		this.terminal 		=  cmdConfigArray[0];
		this.appPath 		=  cmdConfigArray[1];
		this.workingPath 	=  cmdConfigArray[2];
		this.editorChoice 	=  cmdConfigArray[3];
		this.terminalColor 	= cmdConfigArray[4];
	}
	public void setTerminal(String terminal){
		this.terminal = terminal;
	}
	public String getTerminal(){
		return terminal;
	}
	public void setAppPath(String appPath){
		this.appPath = appPath;
	}
	public String getAppPath(){
		return appPath;
	}
	public void setWorkingPath(String workingPath){
		this.workingPath = workingPath;
	}
	public String getWorkingPath(){
		return workingPath;
	}
	public void setEditorChoice(String editorChoice){
		this.editorChoice = editorChoice;
	}
	public String getEditorChoice(){
		return editorChoice;
	}
	public void setterminalColor(String terminalColor){
		this.terminalColor = terminalColor;
	}
	public String getTerminalColor(){
		return terminalColor;
	}
}