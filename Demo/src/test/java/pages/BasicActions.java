package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Preconditions.*;

import stepDefinitions.AppStepDefinition;
import stepDefinitions.GeneralStepDefinitions;
import utils.TLDriverFactory;

import org.openqa.selenium.support.ui.FluentWait.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class BasicActions extends GeneralStepDefinitions {

	public static final int TIME_OUT = 45;
	public WebDriver driver = TLDriverFactory.getTLDriver();
	public WebDriverWait wait;
	public static final Logger LOGGER = LoggerFactory.getLogger(BasicActions.class);

	public BasicActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIME_OUT), this);
		wait = new WebDriverWait(driver, TIME_OUT);
	}

	public void clearField(WebElement element, String elementName) throws Exception {

		LOGGER.info("Clearing element: " + elementName + " statrted");

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
		}

		catch (Exception e) {
			System.out.println("In the catch Block due to Exception = " + e);
			throw new Exception();
		}

		LOGGER.info("Clearing element: " + elementName + " completed successfully");

	}

	public void inputValue(WebElement element, String value, String elementName) throws Exception {
		LOGGER.info("Entering value for element : " + elementName + " with " + value + " started");

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			// element.clear();
			element.sendKeys(value);
		}

		catch (Exception e) {
			System.out.println("In the catch Block due to Exception = " + e);
			throw new Exception();
		}
		LOGGER.info("Entering value for element : " + elementName + " with " + value + " completed");

	}

	public void clickElement(WebElement element, String elementName) throws Exception {

		LOGGER.info("Clicking element: " + elementName + " started");

		try {
			if (element.isEnabled()) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				// element.clear();
				// Thread.sleep(2000);
				element.click();
			}

		}

		catch (Exception e) {

			System.out.println("In the catch Block due to Exception = " + e);
			throw new Exception();

		}
		LOGGER.info("Clicking element: " + elementName + " completed successfully");

	}

	public void clickElementJS(WebElement element, String elementName) throws Exception {

		LOGGER.info("Clicking element: " + elementName + " started");

		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("arguments[0].click();", element);
		}

		catch (Exception e) {
			System.out.println("In the catch Block due to Exception = " + e);
			throw new Exception();

		}
		LOGGER.info("Clicking element: " + elementName + " completed successfully");

	}

	public void verifyFullElementText(WebElement element, String elementName, String expectedText) throws Exception {

		LOGGER.info("Verifying text of element: " + elementName + " statrted");

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			String elementText = element.getText();
			elementText = elementText.replaceAll("\\r\\n|\\r|\\n", " ");
			if (elementText.equalsIgnoreCase(expectedText)) {
				LOGGER.info("Actual text: " + elementText + " is verified with expected text: " + expectedText
						+ " successfully");
			} else {
				LOGGER.info("Actual text: " + elementText + " is not verified with expected text: " + expectedText
						+ " successfully");
				throw new Exception();
			}
		}

		catch (Exception e) {
			System.out.println("In the catch Block due to Exception = " + e);
			throw new Exception();

		}

		LOGGER.info("Verifying text of element: " + elementName + " Completed successfully");

	}

	public void elementIsPresent(WebElement element, String elementName) throws Exception {

		LOGGER.info("Checking presence of Element: " + elementName + " started");

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		catch (Exception e) {
			System.out.println("In the catch Block due to Exception = " + e);
			throw new Exception();

		}

		// System.out.println("In side elementIsPresent method");

		LOGGER.info("Checking presence of Element: " + elementName + " completeed");

	}

	public void hoverAndClick(WebElement elementToHover, String firstString, WebElement elementToClick,
			String secondString) throws Exception {

		LOGGER.info(
				"Hovering on Element: " + firstString + " and then clicking on element " + secondString + " started");

		try {
			Actions action = new Actions(driver);
			// wait.until(ExpectedConditions.visibilityOf(elementToHover));
			action.moveToElement(elementToHover).click(elementToClick).build().perform();
		}

		catch (Exception e) {
			System.out.println("In the catch Block due to Exception = " + e);
			throw new Exception();
		}
		LOGGER.info(
				"Hovering on Element: " + firstString + " and then clicking on element " + secondString + " completed");
	}

	public void hoverOnElement(WebElement elementToHover, String firstString) throws Exception {

		LOGGER.info("Hovering on Element: " + firstString + "  started");

		try {
			Actions action = new Actions(driver);
			// wait.until(ExpectedConditions.visibilityOf(elementToHover));
			action.moveToElement(elementToHover).perform();
		}

		catch (Exception e) {
			System.out.println("In the catch Block due to Exception = " + e);
			throw new Exception();
		}
		LOGGER.info("Hovering on Element: " + firstString + "  completed");
	}

	public void dropDownSelectByText(WebElement element, String VisibleText) throws Exception {

		LOGGER.info("Selection of option by text from dropdown started");

		try {

			// wait.until(ExpectedConditions.elementToBeClickable(element));
			// clickElementJS(element, "dropdown");
			Select selObj = new Select(element);
			selObj.selectByVisibleText(VisibleText);
		}

		catch (Exception e) {
			System.out.println("In the catch Block due to Exception = " + e);
			throw new Exception();
		}

		LOGGER.info("Selection of option by text from dropdown completed");

	}

}
