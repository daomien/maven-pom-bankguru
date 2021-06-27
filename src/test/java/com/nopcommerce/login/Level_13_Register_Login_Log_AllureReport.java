package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;

@Epic("Regression Test")
@Feature("Login Tests")
public class Level_13_Register_Login_Log_AllureReport extends BaseTest {

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
	
	@Description("Login_01_Register_To_System")
	@Story("Register to System")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_01_Register_To_System() {
		log.info("Login_01_Register_To_System: STEP 01 - Open home page");
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		log.info("Login_01_Register_To_System: STEP 02 - Click on register link");
		registerPage = homePage.clickOnRegisterLink();

		log.info("Login_01_Register_To_System: STEP 03 - Select gender");
		registerPage.clickOnGenderRadioButton();

		log.info("Login_01_Register_To_System: STEP 04 - Enter first name");
		registerPage.enterToFirstNameTextbox("Jessica");

		log.info("Login_01_Register_To_System: STEP 05 - Enter last name");
		registerPage.enterToLastNameTextbox("Hen");

		log.info("Login_01_Register_To_System: STEP 06 - Enter email address");
		registerPage.enterToEmailTextbox(emailAddress);

		log.info("Login_01_Register_To_System: STEP 07 - Enter password");
		registerPage.enterToPasswordTextbox(password);

		log.info("Login_01_Register_To_System: STEP 08 - Enter confirm password");
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Login_01_Register_To_System: STEP 09 - Click on register button");
		registerPage.clickOnRegisterButton();

		log.info("Login_01_Register_To_System: STEP 10 - Verify success message displayed after registered");
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickOnLogoutLink();
	}

	@Test
	public void Login_02_Login_To_System() {
		log.info("Login_02_Login_To_System: STEP 01 - Home page - Click on Login link");
		loginPage = homePage.clickOnLoginLink();

		log.info("Login_02_Login_To_System: STEP 02 - Login page - Enter email address");
		loginPage.enterToEmailTextbox(emailAddress);

		log.info("Login_02_Login_To_System: STEP 03 - Login page - Enter password");
		loginPage.enterToPasswordTextbox(password);

		log.info("Login_02_Login_To_System: STEP 04 - Login page - Click on Login button");
		homePage = loginPage.clickOnLoginButton();
		Assert.assertFalse(homePage.isHomePageSliderDisplayed());
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
