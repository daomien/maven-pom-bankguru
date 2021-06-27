package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.SearchProductUI;

public class SearchProductPageObject extends BasePage {
	private WebDriver driver;

	public SearchProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputProductNameSearchTextbox(String searchKeyword) {
		waitForElementVisible(driver, SearchProductUI.SEARCH_PRODUCT_NAME_TEXTBOX);
		sendKeysToElement(driver, SearchProductUI.SEARCH_PRODUCT_NAME_TEXTBOX, searchKeyword);
	}

	public void clickOnSearchButton() {
		waitForElementClickable(driver, SearchProductUI.SEARCH_BUTTON);
		clickToElement(driver, SearchProductUI.SEARCH_BUTTON);
	}

	public boolean isSuccessMessageDisplayed(String successMessage) {
		waitForElementVisible(driver, SearchProductUI.SUCCESS_MESSAGE_UPDATED, successMessage);
		return isElementDisplayed(driver, SearchProductUI.SUCCESS_MESSAGE_UPDATED, successMessage);
	}

	public boolean isPictureImageUpdated(String pictureName, String productName) {
		pictureName = pictureName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, SearchProductUI.IMAGE_UPLOADED_SUCCESS_BY_PICTURE_AND_PRODUCT_NAME, pictureName, productName);
		return isElementDisplayed(driver, SearchProductUI.IMAGE_UPLOADED_SUCCESS_BY_PICTURE_AND_PRODUCT_NAME, pictureName, productName);
	}

	public EditProductDetailsPageObject clickOnEditButtonByProductName(String productName) {
		waitForElementClickable(driver, SearchProductUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, SearchProductUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getEditProductDetailsPage(driver);
	}
}
