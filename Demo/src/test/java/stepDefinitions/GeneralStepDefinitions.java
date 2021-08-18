package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.PropReader;
import utils.TLDriverFactory;

public class GeneralStepDefinitions extends PropReader {

	public WebDriverWait wait;
	// public static WebDriver driver;
	private String operatingSystem = PropReader.getDefaultOperatingSystem();
	private String browser = PropReader.getBrowser();
	private String Link = PropReader.getLink();
	private String userWorkingDirectory = System.getProperty("user.dir");
	private String buildEnviroment = System.getProperty("buildEnvironment");

	@Before
	public void openBrowserWithLink() {

		switch (browser) {

		case "Firefox":
			TLDriverFactory.setTLDriver(browser);
			wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 15);
			TLDriverFactory.getTLDriver().get(Link);
			break;

		case "Chrome":
			TLDriverFactory.setTLDriver(browser);
			wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 15);
			TLDriverFactory.getTLDriver().get(Link);
			break;

		}

	}

	@After
	public synchronized void tearDown() throws Exception {
		TLDriverFactory.getTLDriver().quit();
	}

}
