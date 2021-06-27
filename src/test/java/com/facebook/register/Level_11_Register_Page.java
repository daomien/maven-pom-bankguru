package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_11_Register_Page extends BaseTest {

	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Displayed_on_UI() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());

		registerPage.inputToEmailTextbox("mienmien@gmail.com");
		registerPage.sleepInSeconds(2);
		Assert.assertTrue(registerPage.isEmailConfirmationTextboxDisplayed());
	}

	@Test
	public void Register_02_UnDisplayed_In_DOM() {
		registerPage.inputToEmailTextbox("");
		registerPage.sleepInSeconds(2);
		Assert.assertFalse(registerPage.isEmailConfirmationTextboxDisplayed());

		Assert.assertTrue(registerPage.isEmailConfirmationTextboxUnDisplayed());
	}

	@Test
	public void Register_03_UnDisplayed_Not_In_DOM() {
		Assert.assertTrue(registerPage.isLoginButtonUnDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
