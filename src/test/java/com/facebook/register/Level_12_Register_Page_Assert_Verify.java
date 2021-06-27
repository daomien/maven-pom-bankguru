package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;

public class Level_12_Register_Page_Assert_Verify extends BaseTest {

	WebDriver driver;
	RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Verify() {
		// Failed lan 1
		verifyFalse(registerPage.isEmailTextboxDisplayed());

		registerPage.inputToEmailTextbox("mienmien@gmail.com");
		registerPage.sleepInSeconds(2);

		// Failed lan 2
		verifyFalse(registerPage.isEmailConfirmationTextboxDisplayed());

		registerPage.inputToEmailTextbox("");
		registerPage.sleepInSeconds(2);

		// Failed lan 3
		verifyTrue(registerPage.isEmailConfirmationTextboxDisplayed());

		verifyTrue(registerPage.isEmailConfirmationTextboxUnDisplayed());

		verifyTrue(registerPage.isLoginButtonUnDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
