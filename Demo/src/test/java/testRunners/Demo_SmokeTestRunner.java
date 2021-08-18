package testRunners;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resources/Features/Demo_Smoke.feature", glue = { "stepDefinitions" }, tags = {
		"@SmokeTestSuite1" }, dryRun = false, monochrome = true, plugin = { "pretty",
				"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt",
				"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html" })

public class Demo_SmokeTestRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public static void setup() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("Test User", System.getProperty("user.name").toString());
		Reporter.setSystemInfo("Application Name", "Demo");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", System.getProperty("buildEnvironment").toString());
		Reporter.setTestRunnerOutput("Demo Execution Report");
	}

}
