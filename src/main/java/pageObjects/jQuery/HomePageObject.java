package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnPagingByNumber(String number) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_BY_NUMBER, number);
		clickToElement(driver, HomePageUI.PAGINATION_BY_NUMBER, number);
	}

	public boolean isPageActivatedByNumber(String number) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_ACTIVATED_BY_NUMBER, number);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_ACTIVATED_BY_NUMBER, number);
	}

	public void inputToHeaderByName(String columnName, String valueInput) {
		waitForElementVisible(driver, HomePageUI.TEXTBOX_HEADER_TABLE, columnName);
		sendKeysToElement(driver, HomePageUI.TEXTBOX_HEADER_TABLE, valueInput, columnName);
		pressKeyElement(driver, HomePageUI.TEXTBOX_HEADER_TABLE, Keys.ENTER, columnName);
	}

	public void clickOnIconActionByCountryName(String countryName, String actionName) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, actionName);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, actionName);
	}

	public boolean isRowValueDisplayed(String femaleValue, String countryValue, String maleValue, String totalValue) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE, femaleValue, countryValue, maleValue, totalValue);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE, femaleValue, countryValue, maleValue, totalValue);
	}

	public void inputToRowTextbox(String columnName, String rowIndex, String value) {
		int columnNumber = getElementSize(driver, HomePageUI.HEADER_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_ROW_BY_COLUMN_ROW_INDEX, rowIndex, String.valueOf(columnNumber));
		sendKeysToElement(driver, HomePageUI.TEXTBOX_ROW_BY_COLUMN_ROW_INDEX, value, rowIndex, String.valueOf(columnNumber));
	}

	public void clickOnIconByRowNumber(String rowIndex, String actionName) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowIndex, actionName);
		clickToElement(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowIndex, actionName);
	}
}
