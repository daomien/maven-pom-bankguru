package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_09_DataTable extends BaseTest {

	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homepage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Pagination() {
		homepage.clickOnPagingByNumber("3");
		Assert.assertTrue(homepage.isPageActivatedByNumber("3"));

		homepage.clickOnPagingByNumber("10");
		Assert.assertTrue(homepage.isPageActivatedByNumber("10"));

		homepage.clickOnPagingByNumber("23");
		Assert.assertTrue(homepage.isPageActivatedByNumber("23"));

		homepage.clickOnPagingByNumber("6");
		Assert.assertTrue(homepage.isPageActivatedByNumber("6"));
	}

	// @Test
	public void Table_02_Input_Header_Textbox() {
		homepage.inputToHeaderByName("Females", "1090");
		homepage.refreshCurrentPage(driver);

		homepage.inputToHeaderByName("Country", "Armenia");
		homepage.refreshCurrentPage(driver);

		homepage.inputToHeaderByName("Males", "16456");
		homepage.refreshCurrentPage(driver);

		homepage.inputToHeaderByName("Total", "32487");
		homepage.refreshCurrentPage(driver);
	}

	// @Test
	public void Table_03_Click_Icon() {
		homepage.clickOnIconActionByCountryName("Algeria", "edit");
		homepage.refreshCurrentPage(driver);

		homepage.clickOnIconActionByCountryName("Angola", "edit");
		homepage.refreshCurrentPage(driver);

		homepage.clickOnIconActionByCountryName("Arab Rep of Egypt", "remove");
		homepage.refreshCurrentPage(driver);

		homepage.clickOnIconActionByCountryName("Argentina", "remove");
		homepage.refreshCurrentPage(driver);
	}

	// @Test
	public void Table_04_Verify_Row_Values() {
		homepage.inputToHeaderByName("Country", "Argentina");
		Assert.assertTrue(homepage.isRowValueDisplayed("338282", "Argentina", "349238", "687522"));
		homepage.refreshCurrentPage(driver);

		homepage.inputToHeaderByName("Country", "Arab Rep of Egypt");
		Assert.assertTrue(homepage.isRowValueDisplayed("764956", "Arab Rep of Egypt", "802948", "1567904"));
		homepage.refreshCurrentPage(driver);

		homepage.inputToHeaderByName("Country", "Al");
		Assert.assertTrue(homepage.isRowValueDisplayed("24128", "Albania", "25266", "49397"));
		Assert.assertTrue(homepage.isRowValueDisplayed("283821", "Algeria", "295140", "578961"));
	}

	// @Test
	public void Table_05_Input_Row_Textbox() {
		// driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homepage.inputToRowTextbox("Contact Person", "3", "Contact Row 3");

		homepage.inputToRowTextbox("Order Placed", "1", "Order Row 1");

		homepage.inputToRowTextbox("Company", "2", "Company Row 2");

		homepage.inputToRowTextbox("Member Since", "3", "05/20/1993");
		homepage.sleepInSeconds(3);
	}

	@Test
	public void Table_06_Click_Icon_At_Row() {
		// driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homepage.clickOnIconByRowNumber("2", "Move Up");

		homepage.clickOnIconByRowNumber("3", "Remove Current Row");

		homepage.clickOnIconByRowNumber("2", "Remove Current Row");

		homepage.clickOnIconByRowNumber("1", "Remove Current Row");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homepage;

}
