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
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;
import pageObjects.user.nopCommerce.ShippingAndReturnPageObject;
import pageObjects.user.nopCommerce.SiteMapPageObject;
import pageObjects.user.nopCommerce.WishlistHeaderPageObject;

public class Level_07_Register_Login_Page_Switch_Page extends BaseTest {

	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		emailAddress = getEmailRandom();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		registerPage = homePage.clickOnRegisterLink();
		registerPage.clickOnGenderRadioButton();
		registerPage.enterToFirstNameTextbox("Jessica");
		registerPage.enterToLastNameTextbox("Hen");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickOnRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickOnLogoutLink();
	}

	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clickOnLoginLink();

		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickOnLoginButton();

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void Login_03_Switch_Page() {
		searchPage = homePage.openSearchPage(driver);

		shippingAndReturnPage = searchPage.openShippingAndReturnPage(driver);

		siteMapPage = shippingAndReturnPage.openSiteMapPage(driver);

		myAccountPage = siteMapPage.openMyAccountFooterPage(driver);

		homePage = myAccountPage.openHomePage(driver);

		wishlistHeaderPage = homePage.openWishListPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	SearchPageObject searchPage;
	ShippingAndReturnPageObject shippingAndReturnPage;
	SiteMapPageObject siteMapPage;
	WishlistHeaderPageObject wishlistHeaderPage;
}
