package com.nopcommerce.login;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Environement;
import pageObjects.user.nopCommerce.ComputerPageObject;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;

public class Level_18_Sorting_Product_Run_Multiple_Environment extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	ComputerPageObject computerPage;
	Environement env;

	@Parameters({ "browser" })
	@BeforeClass
	public void initBrowser(String browserName) {
		String environment = System.getProperty("ENV");
		ConfigFactory.setProperty("env", environment);
		env = ConfigFactory.create(Environement.class);

		log.info("Pre-condition: Initial browser driver");
		driver = getBrowserDriver(browserName, env.url());

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openSubmenuByMenuName("Computers");
		log.info("Pre-condition: Hover on 'Computers' menu ");
		homePage.openProductPageBySubmenu("Notebooks");
		log.info("Pre-condition: Hover on 'Notebooks' submenu ");
	}

	@Test
	public void Sorting_01_Sort_By_Product_Name() {
		computerPage = PageGeneratorManager.getComputerPage(driver);
		log.info("Sorting_01: Step 1 - Sort product name by ASC order");
		verifyTrue(computerPage.isProductSortedByNameAscendingOrder("Name: A to Z"));
		computerPage.sleepInSeconds(3);

		log.info("Sorting_01: Step 2 - Sort product name by DESC order");
		verifyTrue(computerPage.isProductSortedByNameDescendingOrder("Name: Z to A"));
		computerPage.sleepInSeconds(3);
	}

	@Test
	public void Sorting_02_Sort_By_Price() {
		log.info("Sorting_02: Step 1 - Sort price product by ASC order");
		verifyTrue(computerPage.isProductSortedByPriceAscendingOrder("Price: Low to High"));
		computerPage.sleepInSeconds(3);

		log.info("Sorting_02: Step 1 - Sort price produce by DESC order");
		verifyTrue(computerPage.isProductSortedByPriceDescendingOrder("Price: High to Low"));
		computerPage.sleepInSeconds(3);
	}

	@AfterClass
	public void afterClass() {
		log.info("Post-condition: Close browser");
		driver.quit();
	}

}
