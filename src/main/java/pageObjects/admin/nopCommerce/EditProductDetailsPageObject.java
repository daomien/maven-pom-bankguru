package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.EditProductDetailsUI;

public class EditProductDetailsPageObject extends BasePage {
	private WebDriver driver;

	public EditProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnExpandPanelBySectionName(String sectionName) {
		waitForElementVisible(driver, EditProductDetailsUI.SECTION_NAME, sectionName);
		scrollToElement(driver, EditProductDetailsUI.SECTION_NAME, sectionName);
		if (!isElementDisplayed(driver, EditProductDetailsUI.EXPAND_BUTTON_BY_SECTION_NAME, sectionName)) {
			clickToElement(driver, EditProductDetailsUI.EXPAND_BUTTON_BY_SECTION_NAME, sectionName);
		}
	}

	public void inputAltTextbox(String valueAlt) {
		waitForElementVisible(driver, EditProductDetailsUI.ALT_PICTURE_TEXTBOX, valueAlt);
		sendKeysToElement(driver, EditProductDetailsUI.ALT_PICTURE_TEXTBOX, valueAlt);
	}

	public void inputTitleTextbox(String valueTitle) {
		waitForElementVisible(driver, EditProductDetailsUI.TITLE_PICTURE_TEXTBOX, valueTitle);
		sendKeysToElement(driver, EditProductDetailsUI.TITLE_PICTURE_TEXTBOX, valueTitle);

	}

	public void clickDecreaseDisplayOrder() {
		waitForElementClickable(driver, EditProductDetailsUI.DISPLAY_ORDER_DROPDOWN);
		clickToElement(driver, EditProductDetailsUI.DISPLAY_ORDER_DROPDOWN);
	}

	public void clickOnAddProductPictureButton() {
		waitForElementClickable(driver, EditProductDetailsUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, EditProductDetailsUI.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean isPictureImageDisplayed(String pictureName, String orderNumber, String altPicture, String titlePicture) {
		pictureName = pictureName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, EditProductDetailsUI.TABLE_PRODUCT_PICTURE_ADDED, pictureName, orderNumber, altPicture, titlePicture);
		return isElementDisplayed(driver, EditProductDetailsUI.TABLE_PRODUCT_PICTURE_ADDED, pictureName, orderNumber, altPicture, titlePicture);
	}

	public SearchProductPageObject clickOnSaveButton() {
		waitForElementVisible(driver, EditProductDetailsUI.SAVE_BUTTON);
		scrollToElement(driver, EditProductDetailsUI.SAVE_BUTTON);

		waitForElementClickable(driver, EditProductDetailsUI.SAVE_BUTTON);
		clickToElement(driver, EditProductDetailsUI.SAVE_BUTTON);
		return PageGeneratorManager.getSearchProductPage(driver);
	}

	public boolean isUploadedImageSuccessByFileName(String fileName) {
		fileName = fileName.split("\\.")[0];
		waitForElementVisible(driver, EditProductDetailsUI.PICTURE_UPLOADED_BY_FILE_NAME, fileName);
		return isElementDisplayed(driver, EditProductDetailsUI.PICTURE_UPLOADED_BY_FILE_NAME, fileName);
	}

	public void clickOnDeleteButtonByTitlePictureName(String titlePicture) {
		waitForElementClickable(driver, EditProductDetailsUI.DELETE_BUTTON_BY_TITLE_PICTURE, titlePicture);
		clickToElement(driver, EditProductDetailsUI.DELETE_BUTTON_BY_TITLE_PICTURE, titlePicture);
		acceptAlert(driver);
	}

	public void scrollToElementBySectionName(String sectionName) {
		waitForElementVisible(driver, EditProductDetailsUI.SECTION_NAME, sectionName);
		scrollToElement(driver, EditProductDetailsUI.SECTION_NAME, sectionName);

	}
}
