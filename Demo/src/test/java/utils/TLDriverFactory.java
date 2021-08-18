package utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Preconditions.*;
import com.google.common.base.Function;

public class TLDriverFactory {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public synchronized static void setTLDriver(String browser) {
		if (browser.equals("Firefox")) {
			tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(OptionsManager.getFirefoxOptions()));
		} else if (browser.equals("Chrome")) {
			tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(OptionsManager.getChromeOptions()));
		}
	}

	public synchronized static WebDriver getTLDriver() {
		return tlDriver.get();
	}
}
