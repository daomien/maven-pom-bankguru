package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.DashboardPageUI;

public class DashboardPageObject extends BasePage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLogoAtDashboardPageDisplayed() {
		waitForElementVisible(driver, DashboardPageUI.IMG_LOGO);
		return isElementDisplayed(driver, DashboardPageUI.IMG_LOGO);
	}

}
