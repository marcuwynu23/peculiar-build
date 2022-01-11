package builder;


public class ConfigLoader{
	private ConfigFileHandler configFileHandler;
	private String[] config;
	public ConfigLoader(){
		load();
	}
	private void load(){
		configFileHandler = new ConfigFileHandler("peculiar.conf");
		config = configFileHandler.getConfigFromFile();

	}
	public void changeConfig(String[] changeConfig){
		configFileHandler.setConfigToFile(changeConfig);
		config = changeConfig;
	}
	public String[] getConfig(){
		return config;
	}
	public CommandConfig getConfiguration(){
		var conf = new CommandConfig(config);
		return conf;
	}
}