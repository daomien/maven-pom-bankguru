package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_03_Register_Login_Page_Object {

	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String emailAddress, password;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		emailAddress = getEmailRandom();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		driver.get("https://demo.nopcommerce.com/");
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

	public String getEmailRandom() {
		Random rand = new Random();
		return "testing" + rand.nextInt(999) + "@gmail.com";
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
