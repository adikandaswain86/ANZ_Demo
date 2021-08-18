package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicActions {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"account_drop_trigger\"]/span/span")
	private WebElement mainLoginLink;

	@FindBy(xpath = "//*[@id=\"account_drop\"]/div[1]/div/div[2]/button[1]")
	private WebElement secondaryLoginLink;

	@FindBy(xpath = "//*[@id=\"account_drop\"]/div[1]/div/div[2]/button[2]")
	private WebElement createAccountLink;

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(id = "register_email")
	private WebElement registerEmail;

	@FindBy(id = "register_password")
	private WebElement registerPassword;

	@FindBy(id = "biRegMonth")
	private WebElement biRegMonth;

	@FindBy(id = "biRegDay")
	private WebElement biRegDay;

	@FindBy(xpath = "//*[@id=\"modal0Dialog\"]/div[2]/form/div[10]/button")
	private WebElement joinNowButton;

	@FindBy(id = "signin_username")
	private WebElement signinUserName;

	@FindBy(id = "signin_password")
	private WebElement signinPassword;

	@FindBy(xpath = "//*[@id=\"modal0Dialog\"]/div[1]/form/button")
	private WebElement actualLoginLink;

	public LoginPage hoverAndClickOnCreateAccount() throws Exception {

		hoverOnElement(mainLoginLink, "Sign In link");
		clickElement(createAccountLink, "Create Account Button");

		return this;
	}

	public LoginPage hoverAndClickOnSecondarySignIn() throws Exception {

		hoverOnElement(mainLoginLink, "Sign In link");
		clickElement(secondaryLoginLink, "secondaryLoginLink");

		return this;
	}

	public LoginPage enterFirstName(String firstName) throws Exception {

		Random rand = new Random();
		String newFirstName = firstName + Integer.toString(rand.nextInt(100));
		clearField(this.firstName, "firstName");
		inputValue(this.firstName, newFirstName, "firstName");

		return this;
	}

	public LoginPage enterLastName(String lastName) throws Exception {

		Random rand = new Random();
		String newLastName = lastName + Integer.toString(rand.nextInt(100));
		clearField(this.lastName, "lastName");
		inputValue(this.lastName, newLastName, "lastName");

		return this;
	}

	public LoginPage enterEmailId(String emailID) throws Exception {

		/*
		 * Random rand = new Random(); String
		 * newEmailID=emailID+Integer.toString(rand.nextInt(100));
		 */
		clearField(this.registerEmail, "registerEmail");
		inputValue(this.registerEmail, emailID, "registerEmail");

		return this;
	}

	public LoginPage enterPassword(String passWord) throws Exception {

		clearField(this.registerPassword, "registerPassword");
		inputValue(this.registerPassword, passWord, "registerPassword");

		return this;
	}

	public LoginPage enterMonth(String month) throws Exception {

		dropDownSelectByText(biRegMonth, month);

		return this;
	}

	public LoginPage enterDay(String day) throws Exception {

		dropDownSelectByText(biRegDay, day);

		return this;
	}

	public HomePage clickOnJoinNowdLink() throws Exception {

		clickElement(joinNowButton, "joinNowButton");
		return new HomePage(driver);
	}

	public HomePage successfulLogin() throws Exception {
		clearField(this.signinUserName, "signinUserName");
		inputValue(this.signinUserName, username, "signinUserName");
		clearField(this.signinPassword, "signinPassword");
		inputValue(this.signinPassword, password, "signinPassword");
		clickElement(this.actualLoginLink, "actualLoginLink");
		return new HomePage(driver);

	}

}
