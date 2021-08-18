package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class PropReader {

	public static String operatingSystem, browser, Link, username, password;

	public PropReader() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
			operatingSystem = prop.getProperty("OS");
			browser = prop.getProperty("BROWSER");
			Link = prop.getProperty("URL");
			username = prop.getProperty("USERNAME");
			password = prop.getProperty("PASSWORD");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getUser() {
		return username;

	}

	public static String getPassword() {
		return password;
	}

	public static String getDefaultOperatingSystem() {
		return operatingSystem;
	}

	public static String getBrowser() {
		return browser;
	}

	public static String getLink() {
		return Link;
	}

}
