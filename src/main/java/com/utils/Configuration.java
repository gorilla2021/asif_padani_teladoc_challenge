package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public static String getConfig(String key) throws IOException {		
		Properties properties = new Properties();		
		FileInputStream file = new FileInputStream(new File("Config.properties"));		
		properties.load(file);
		return properties.get(key).toString();
	}
}
