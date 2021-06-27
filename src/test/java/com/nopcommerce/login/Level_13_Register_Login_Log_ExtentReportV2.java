package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_13_Register_Login_Log_ExtentReportV2 extends BaseTest {

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

//	@Test
//	public void Login_01_Register_To_System(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Login_01_Register_To_System");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System - Step 01: Open 'New Customer' page");
//		homePage = PageGeneratorManager.getHomePage(driver);
//		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System: STEP 02 - Click on register link");
//		registerPage = homePage.clickOnRegisterLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System: STEP 03 - Select gender");
//		registerPage.clickOnGenderRadioButton();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System: STEP 04 - Enter first name");
//		registerPage.enterToFirstNameTextbox("Jessica");
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System: STEP 05 - Enter last name");
//		registerPage.enterToLastNameTextbox("Hen");
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System: STEP 06 - Enter email address: " + emailAddress);
//		registerPage.enterToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System: STEP 07 - Enter password: " + password);
//		registerPage.enterToPasswordTextbox(password);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System: STEP 08 - Enter confirm password");
//		registerPage.enterToConfirmPasswordTextbox(password);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System: STEP 09 - Click on register button");
//		registerPage.clickOnRegisterButton();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_01_Register_To_System: STEP 10 - Verify success message displayed after registered");
//		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
//		homePage = registerPage.clickOnLogoutLink();
//	}
//
//	@Test
//	public void Login_02_Login_To_System(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Login_02_Login_To_System");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_02_Login_To_System: STEP 01 - Home page - Click on Login link");
//		loginPage = homePage.clickOnLoginLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_02_Login_To_System: STEP 02 - Login page - Enter email address: " + emailAddress);
//		loginPage.enterToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_02_Login_To_System: STEP 03 - Login page - Enter password: " + password);
//		loginPage.enterToPasswordTextbox(password);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login_02_Login_To_System: STEP 04 - Login page - Click on Login button");
//		homePage = loginPage.clickOnLoginButton();
//		Assert.assertFalse(homePage.isHomePageSliderDisplayed());
//	}

	@AfterClass
	public void afterClass() {
		log.info("Post-condition: Close browser");
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
