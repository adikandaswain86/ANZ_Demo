package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import stepDefinitions.AppStepDefinition;

public class MyBasketPage extends ProductPage {

	public MyBasketPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h1[contains(text(),'My Basket')]")
	private WebElement myBasketHeader;

	@FindBy(xpath = "//span[@data-at=\"bsk_sku_name\"]")
	private WebElement productNameMyBasket;

	public MyBasketPage validateMyBasketPage() throws Exception

	{
		elementIsPresent(myBasketHeader, "myBasketHeader");
		return this;
	}

	public MyBasketPage validateProductDetailsOnMyBasketPage(String productName) throws Exception

	{
		verifyFullElementText(productNameMyBasket, "productNameMyBasket", productName);
		return this;
	}

}
