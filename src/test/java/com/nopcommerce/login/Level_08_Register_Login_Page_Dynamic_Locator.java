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

public class Level_08_Register_Login_Page_Dynamic_Locator extends BaseTest {

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
	public void Login_03_C1_Switch_Page() {
		searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");

		shippingAndReturnPage = (ShippingAndReturnPageObject) searchPage.getFooterPageByName(driver, "Shipping & returns");

		siteMapPage = (SiteMapPageObject) shippingAndReturnPage.getFooterPageByName(driver, "Sitemap");

		myAccountPage = (MyAccountPageObject) siteMapPage.getFooterPageByName(driver, "My account");
	}

	@Test
	public void Login_04_C2_Open_Footer_Page() {
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		searchPage.openFooterPageByName(driver, "Shipping & returns");

		shippingAndReturnPage = PageGeneratorManager.getShippingAndReturnPage(driver);
		shippingAndReturnPage.openFooterPageByName(driver, "Sitemap");

		siteMapPage = PageGeneratorManager.getSiteMapePage(driver);
		siteMapPage.openFooterPageByName(driver, "My account");

		// homePage = myAccountPage.openHomePage(driver);

		// wishlistHeaderPage = homePage.openWishListPage(driver);
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
