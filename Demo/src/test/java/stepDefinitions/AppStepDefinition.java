package stepDefinitions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasicActions;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.MyBasketPage;
import utils.PropReader;
import utils.TLDriverFactory;

public class AppStepDefinition {

	private String username = PropReader.getUser();
	private String password = PropReader.getPassword();

	private WebDriver driver = TLDriverFactory.getTLDriver();
	private LoginPage demoLoginPage = new LoginPage(driver);
	private static HomePage demoHomePage;
	private static ProductPage demoProductPage;
	private static MyBasketPage demoMyBasketPage;
	private static String productDetails;

	@When("^User hovers and clicks on create account link$")
	public void user_hovers_and_clicks_on_create_account_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		demoLoginPage.hoverAndClickOnCreateAccount();

		Thread.sleep(4000);

	}

	@When("^User enters first name \"([^\"]*)\",last name\"([^\"]*)\",emailid\"([^\"]*)\",password\"([^\"]*)\",month \"([^\"]*)\" and day \"([^\"]*)\"$")
	public void user_enters_first_name_last_name_emailid_password_month_and_day(String arg1, String arg2, String arg3,
			String arg4, String arg5, String arg6) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoLoginPage.enterFirstName(arg1);
		demoLoginPage.enterLastName(arg2);
		demoLoginPage.enterEmailId(arg3);
		demoLoginPage.enterPassword(arg4);
		demoLoginPage.enterMonth(arg5);
		demoLoginPage.enterDay(arg6);

		Thread.sleep(4000);
	}

	@When("^User clicks on join now$")
	public void user_clicks_on_join_now() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		demoHomePage = demoLoginPage.clickOnJoinNowdLink();

		Thread.sleep(4000);

	}

	@Then("^sign up should be successful$")
	public void sign_up_should_be_successful_and_validate_user_firstname_on_home_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoHomePage.validateHomePageOnSignUp();
		demoHomePage.validateUserNameOnHomePageOnSignUp();

		Thread.sleep(4000);

	}

	@Given("^User logs in using valid username and password$")
	public void user_logs_in_using_valid_username_and_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoLoginPage.hoverAndClickOnSecondarySignIn();
		demoHomePage = demoLoginPage.successfulLogin();

		Thread.sleep(4000);
	}

	@Given("^login is successfull with the username \"([^\"]*)\"$")
	public void login_is_successfull_with_the_username(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoHomePage.validateHomePage();
		demoHomePage.validateUserNameOnHomePage(arg1);
		demoHomePage.clearCart();

		Thread.sleep(4000);
	}

	@When("^user selects and adds product to cart and checksout$")
	public void user_selects_and_adds_product_to_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoProductPage = demoHomePage.hoverAndClickOnBrandsLink();
		productDetails = Product_details_are_saved_before_clicking_on_product_name();
		demoProductPage.validateProductPage();
		demoProductPage.clickOnProduct();
		demoProductPage.clickOnAddToBasket();
		demoMyBasketPage = demoProductPage.clickOnCheckOut();
		Thread.sleep(4000);
	}

	@When("^User lands on my basket page$")
	public void user_lands_on_my_basket_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoMyBasketPage.validateMyBasketPage();
		Thread.sleep(4000);
	}

	@Then("^validate selected product is available in my basket$")
	public void validate_selected_product_is_available_in_my_basket() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoMyBasketPage.validateProductDetailsOnMyBasketPage(productDetails);
		Thread.sleep(4000);
	}

	// @When("^Product details are saved before clicking on product name$")
	public static String Product_details_are_saved_before_clicking_on_product_name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		setProductDetails(demoProductPage.collectProductName());

		Thread.sleep(2000);
		return getProductDetails();

	}

	public static String getProductDetails() {
		return productDetails;
	}

	public static void setProductDetails(String productDetails) {
		AppStepDefinition.productDetails = productDetails;
	}

}
