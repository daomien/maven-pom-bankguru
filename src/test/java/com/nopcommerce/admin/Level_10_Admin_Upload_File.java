package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.nopCommerce.DashboardPageObject;
import pageObjects.admin.nopCommerce.EditProductDetailsPageObject;
import pageObjects.admin.nopCommerce.LoginPageObject;
import pageObjects.admin.nopCommerce.PageGeneratorManager;
import pageObjects.admin.nopCommerce.SearchProductPageObject;

public class Level_10_Admin_Upload_File extends BaseTest {
	WebDriver driver;

	String menuName = "Catalog";
	String subMenuName = "Products";
	String productName = "Adobe Photoshop CS4";
	String sectionName = "Pictures";
	String imageName = "Report_Status.png";
	String cardName = "product-pictures";
	String altImageName = "PTS alt image";
	String titleImageName = "PTS title image";

	DashboardPageObject dashboardPage;
	LoginPageObject loginPage;
	SearchProductPageObject searchProductPage;
	EditProductDetailsPageObject editProductDetailsPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.inputToEmailTextbox("admin@yourstore.com");
		loginPage.inputToPasswordTextbox("admin");
		dashboardPage = loginPage.clickOnLoginButton();

		dashboardPage.openProductsPage(driver, menuName, subMenuName);

		searchProductPage = PageGeneratorManager.getSearchProductPage(driver);
		searchProductPage.inputProductNameSearchTextbox(productName);
		searchProductPage.clickOnSearchButton();
		editProductDetailsPage = searchProductPage.clickOnEditButtonByProductName(productName);
	}

	@Test
	public void Admin_01_Upload_File() {
		editProductDetailsPage.clickOnExpandPanelBySectionName(sectionName);
		editProductDetailsPage.uploadFileByCardName(driver, cardName, imageName);
		Assert.assertTrue(editProductDetailsPage.isUploadedImageSuccessByFileName(imageName));

		editProductDetailsPage.inputAltTextbox(altImageName);
		editProductDetailsPage.inputTitleTextbox(titleImageName);
		editProductDetailsPage.clickDecreaseDisplayOrder();
		editProductDetailsPage.clickOnAddProductPictureButton();

		Assert.assertTrue(editProductDetailsPage.isPictureImageDisplayed(productName, "1", altImageName, titleImageName));

		searchProductPage = editProductDetailsPage.clickOnSaveButton();
		Assert.assertTrue(searchProductPage.isSuccessMessageDisplayed("The product has been updated successfully."));

		searchProductPage.inputProductNameSearchTextbox(productName);
		searchProductPage.clickOnSearchButton();

		Assert.assertTrue(searchProductPage.isPictureImageUpdated(productName, productName));

		editProductDetailsPage = searchProductPage.clickOnEditButtonByProductName(productName);
		editProductDetailsPage.clickOnExpandPanelBySectionName(sectionName);
		editProductDetailsPage.clickOnDeleteButtonByTitlePictureName(titleImageName); // Accept Alert
		Assert.assertTrue(editProductDetailsPage.isEmptyMessageInTableDisplayedByCardName(driver, cardName));

		searchProductPage = editProductDetailsPage.clickOnSaveButton();

		searchProductPage.inputProductNameSearchTextbox(productName);
		searchProductPage.clickOnSearchButton();
		Assert.assertTrue(searchProductPage.isPictureImageUpdated("default-image", productName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
