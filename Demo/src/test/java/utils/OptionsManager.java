package utils;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager {

	// Get Chrome Options
	public static ChromeOptions getChromeOptions() {

		ChromeOptions options = new ChromeOptions();

		// Headless browser---Start
		// options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		// Headless browser---End

		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-popup-blocking");
		options.setAcceptInsecureCerts(true);
		options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
		// options.setBinary(new File("C:\\Program
		// Files\\Google\\Chrome\\Application\\chrome.exe"));
		options.addArguments("disable-infobars");

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Resorces\\Drivers\\Windows\\chromedriver_92.exe");
		return options;

	}

	// Get Firefox Options
	public static FirefoxOptions getFirefoxOptions() {

		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\Resorces\\Drivers\\Windows\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		// Accept Untrusted Certificates
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		// Use No Proxy Settings
		profile.setPreference("network.proxy.type", 0);
		// Set Firefox Profile to Capabilities
		options.setCapability(FirefoxDriver.PROFILE, profile);
		return options;
	}
}
