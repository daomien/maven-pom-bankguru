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
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_05_Register_Login_Page_Factory extends BaseTest {

	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String emailAddress, password;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		emailAddress = getEmailRandom();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		homePage.clickOnRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.clickOnGenderRadioButton();

		registerPage.enterToFirstNameTextbox("Jessica");

		registerPage.enterToLastNameTextbox("Hen");

		registerPage.enterToEmailTextbox(emailAddress);

		registerPage.enterToPasswordTextbox(password);

		registerPage.enterToConfirmPasswordTextbox(password);

		registerPage.clickOnRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		registerPage.clickOnLogoutLink();
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Login_02_Login_To_System() {
		homePage.clickOnLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTextbox(emailAddress);

		loginPage.enterToPasswordTextbox(password);

		loginPage.clickOnLoginButton();

		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
