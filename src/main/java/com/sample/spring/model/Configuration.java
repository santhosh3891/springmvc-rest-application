package com.sample.spring.model;

public class Configuration {
	private int configId;
	private String configName;
	private String configDescription;
	
	public Configuration(int configId, String configName, String configDescription) {
		this.configId = configId;
		this.configName = configName;
		this.configDescription = configDescription;
	}

	public int getConfigId() {
		return configId;
	}

	public String getConfigName() {
		return configName;
	}

	public String getConfigDescription() {
		return configDescription;
	}
}
