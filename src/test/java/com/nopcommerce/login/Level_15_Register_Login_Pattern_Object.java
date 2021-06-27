package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_15_Register_Login_Pattern_Object extends BaseTest {

	WebDriver driver;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		log.info("Pre-condition: Initial browser driver");
		driver = getBrowserDriver(browserName, url);
		emailAddress = getEmailRandom();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		log.info("Login_01_Register_To_System: STEP 01 - Open home page");
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		log.info("Login_01_Register_To_System: STEP 02 - Click on register link");
		homePage.clickOnHeaderLinkByName(driver, "Register");

		registerPage = PageGeneratorManager.getRegisterPage(driver);
		log.info("Login_01_Register_To_System: STEP 03 - Select gender");
		registerPage.clickOnGenderRadioButton();

		log.info("Login_01_Register_To_System: STEP 04 - Enter first name");
		registerPage.enterToTextboxById(driver, "Jessica", "FirstName");

		log.info("Login_01_Register_To_System: STEP 05 - Enter last name");
		registerPage.enterToTextboxById(driver, "Hen", "LastName");

		log.info("Login_01_Register_To_System: STEP 06 - Enter email address");
		registerPage.enterToTextboxById(driver, emailAddress, "Email");

		log.info("Login_01_Register_To_System: STEP 07 - Enter password");
		registerPage.enterToTextboxById(driver, password, "Password");

		log.info("Login_01_Register_To_System: STEP 08 - Enter confirm password");
		registerPage.enterToTextboxById(driver, password, "ConfirmPassword");

		log.info("Login_01_Register_To_System: STEP 09 - Click on register button");
		registerPage.clickOnButtonByName(driver, "Register");

		log.info("Login_01_Register_To_System: STEP 10 - Verify success message displayed after registered");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		registerPage.clickOnHeaderLinkByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Login_02_Login_To_System() {
		log.info("Login_02_Login_To_System: STEP 01 - Home page - Click on Login link");
		homePage.clickOnHeaderLinkByName(driver, "Log in");

		loginPage = PageGeneratorManager.getLoginPage(driver);
		log.info("Login_02_Login_To_System: STEP 02 - Login page - Enter email address");
		loginPage.enterToTextboxById(driver, emailAddress, "Email");

		log.info("Login_02_Login_To_System: STEP 03 - Login page - Enter password");
		loginPage.enterToTextboxById(driver, password, "Password");

		log.info("Login_02_Login_To_System: STEP 04 - Login page - Click on Login button");
		loginPage.clickOnButtonByName(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@AfterClass
	public void afterClass() {
		log.info("Post-condition: Close browser");
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
