package fr.eni.inscrite.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {
	
	private static Properties properties;
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
			properties.loadFromXML(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		String parametre = properties.getProperty(key);
		return parametre;
	}
	
}
