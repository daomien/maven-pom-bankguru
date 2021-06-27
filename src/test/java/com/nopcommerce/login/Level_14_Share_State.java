package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_14_Share_State extends BaseTest {

	WebDriver driver;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		log.info("Pre-condition: Initial browser driver");
		driver = getBrowserDriver(browserName, url);
		System.out.println("Driver browser: " + driver);
		homePage = PageGeneratorManager.getHomePage(driver);

		emailAddress = getEmailRandom();
		password = "123456";

		log.info("Pre-condition: STEP 01 - Home page - Click on Login link");
		loginPage = homePage.clickOnLoginLink();

		log.info("Pre-condition: STEP 03 - Set login page cookie");
		loginPage.setAllCookies(driver, Common_01_Login.getAllCookies);
		loginPage.sleepInSeconds(5);
		loginPage.refreshCurrentPage(driver);

		log.info("Pre: STEP 02 - Click on Logo to go Homepage");
		homePage = loginPage.clickOnLogoHomepage();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void TC_01() {
	}

	@Test
	public void TC_02() {
	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
