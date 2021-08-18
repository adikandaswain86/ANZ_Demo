package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends HomePage {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[contains(text(),\"Brightening Eye Cream – Hydrate & Depuff\")]")
	private WebElement productLinks;

	@FindBy(xpath = "//div[@class=\"css-0\"]/div/div/button")
	private WebElement addToBasket;

	@FindBy(xpath = "(//div[contains(text(),\"View Basket & Checkout\")]/following-sibling::div)[1]")
	private WebElement checkOut;

	/*
	 * @FindBy(xpath="//div[@class=\"css-1gughuu\"]/span[2]") private WebElement
	 * productName;
	 */

	public ProductPage validateProductPage() throws Exception

	{
		elementIsPresent(productLinks, "productLinks");
		return this;
	}

	public ProductPage clickOnProduct() throws Exception

	{

		clickElement(productLinks, "productLinks");
		return this;
	}

	public ProductPage clickOnAddToBasket() throws Exception

	{

		clickElement(addToBasket, "addToBasket");
		return this;
	}

	public MyBasketPage clickOnCheckOut() throws Exception

	{

		clickElement(checkOut, "checkOut");
		return new MyBasketPage(driver);
	}

	public String collectProductName() throws Exception

	{

		return productLinks.getText();
	}

}
