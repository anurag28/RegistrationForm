package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static String filePath = System.getProperty("user.dir") + File.separator + "config.properties";
	
	public static String getUrl() throws FileNotFoundException, IOException {
		Properties prop = new Properties();

	    prop.load(new FileInputStream(filePath));
	
	    String fileName = prop.getProperty("url");
	   
	    return "file://" + File.separator +System.getProperty("user.dir")+ File.separator + fileName;
	}
	
	public static String getProperty(String property) throws FileNotFoundException, IOException {
		Properties prop = new Properties();

		prop.load(new FileInputStream(filePath));
	    return prop.getProperty(property);
	
	}
}
