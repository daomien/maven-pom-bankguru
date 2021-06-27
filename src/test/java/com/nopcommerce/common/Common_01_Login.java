package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Common_01_Login extends BaseTest {

	WebDriver driver;
	String emailAddress, password;

	public static Set<Cookie> getAllCookies;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String url) {
		log.info("Pre-condition: Initial browser driver");
		driver = getBrowserDriver(browserName, url);
		emailAddress = getEmailRandom();
		password = "123456";

		log.info("Common_01: STEP 01 - Open home page");
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		log.info("Common_01: STEP 02 - Click on register link");
		registerPage = homePage.clickOnRegisterLink();

		log.info("Common_01: STEP 03 - Select gender");
		registerPage.clickOnGenderRadioButton();

		log.info("Common_01: STEP 04 - Enter first name");
		registerPage.enterToFirstNameTextbox("Jessica");

		log.info("Common_01: STEP 05 - Enter last name");
		registerPage.enterToLastNameTextbox("Hen");

		log.info("Common_01: STEP 06 - Enter email address");
		registerPage.enterToEmailTextbox(emailAddress);

		log.info("Common_01: STEP 07 - Enter password");
		registerPage.enterToPasswordTextbox(password);

		log.info("Common_01: STEP 08 - Enter confirm password");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Common_01: STEP 09 - Click on register button");
		registerPage.clickOnRegisterButton();

		log.info("Common_01: STEP 10 - Verify success message displayed after registered");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickOnLogoutLink();

		log.info("Common_01: STEP 11 - Home page - Click on Login link");
		loginPage = homePage.clickOnLoginLink();

		log.info("Common_01: STEP 12 - Login page - Enter email address" + emailAddress);
		loginPage.enterToEmailTextbox(emailAddress);

		log.info("Common_01: STEP 13 - Login page - Enter password" + password);
		loginPage.enterToPasswordTextbox(password);

		log.info("Common_01: STEP 14 - Login page - Click on Login button");
		homePage = loginPage.clickOnLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		log.info("Common_01: STEP 18 - Get all login page cookie");
		getAllCookies = homePage.getAllCookies(driver);
		
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
