package com.liveguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

public class Level_04_Register_Login_Mutiple_Browsers extends BaseTest {

	WebDriver driver;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		homePage = new HomePageObject(driver);
		homePage.clickOnMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox("abcd@abcd");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Password less than 6 characters")
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox("abcd@abcd.com");
		loginPage.enterToPasswordTextbox("123");
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test(description = "Email not exist in the system")
	public void Login_04_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox("abcd@abcd1234.com");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getIncorrectEmaiOrPasswordErrorMessage(), "Invalid login or password.");

	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox("dam@gmail.com");
		loginPage.enterToPasswordTextbox("123456zxcvbnm");
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.getIncorrectEmaiOrPasswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox("dam@gmail.com");
		loginPage.enterToPasswordTextbox("123123");
		loginPage.clickOnLoginButton();

		myDashboardPage = new MyDashboardPageObject(driver);

		Assert.assertTrue(myDashboardPage.isMyDashboardDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;

}
