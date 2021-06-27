package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.ComputerPageUI;

public class ComputerPageObject extends BasePage {
	WebDriver driver;

	public ComputerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductSortedByNameAscendingOrder(String sortBy) {
		waitForElementClickable(driver, ComputerPageUI.SELECT_DROPDOWN_SORT);
		selectDropdownByText(driver, ComputerPageUI.SELECT_DROPDOWN_SORT, sortBy);
		waitForElementInvisible(driver, ComputerPageUI.ICON_LOADING);
		waitForAllElementsVisible(driver, ComputerPageUI.TEXT_PRODUCT_NAME);
		return isDataStringSortedByAscending(driver, ComputerPageUI.TEXT_PRODUCT_NAME);
	}

	public boolean isProductSortedByNameDescendingOrder(String sortBy) {
		waitForElementClickable(driver, ComputerPageUI.SELECT_DROPDOWN_SORT);
		selectDropdownByText(driver, ComputerPageUI.SELECT_DROPDOWN_SORT, sortBy);
		waitForElementInvisible(driver, ComputerPageUI.ICON_LOADING);
		waitForAllElementsVisible(driver, ComputerPageUI.TEXT_PRODUCT_NAME);
		return isDataStringSortedByDescending(driver, ComputerPageUI.TEXT_PRODUCT_NAME);
	}

	public boolean isProductSortedByPriceAscendingOrder(String sortBy) {
		waitForElementClickable(driver, ComputerPageUI.SELECT_DROPDOWN_SORT);
		selectDropdownByText(driver, ComputerPageUI.SELECT_DROPDOWN_SORT, sortBy);
		waitForElementInvisible(driver, ComputerPageUI.ICON_LOADING);
		waitForAllElementsVisible(driver, ComputerPageUI.TEXT_PRICE_PRODUCT);
		return isDataFloatSortedByAscending(driver, ComputerPageUI.TEXT_PRICE_PRODUCT);
	}

	public boolean isProductSortedByPriceDescendingOrder(String sortBy) {
		waitForElementClickable(driver, ComputerPageUI.SELECT_DROPDOWN_SORT);
		selectDropdownByText(driver, ComputerPageUI.SELECT_DROPDOWN_SORT, sortBy);
		waitForElementInvisible(driver, ComputerPageUI.ICON_LOADING);
		waitForAllElementsVisible(driver, ComputerPageUI.TEXT_PRICE_PRODUCT);
		return isDataFloatSortedByDescending(driver, ComputerPageUI.TEXT_PRICE_PRODUCT);
	}

}
