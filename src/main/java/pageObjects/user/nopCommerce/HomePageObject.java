package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		System.out.println("Driver Web Home: " + driver);
		this.driver = driver;
	}

	@Step("Verify home page slider displayed")
	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}

	@Step("Click on Register Link")
	public RegisterPageObject clickOnRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}


	@Step("Click on Login Link")
	public LoginPageObject clickOnLoginLink() {
		System.out.println("Driver - Click on Login Link from Homepage: " + driver);
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public void openSubmenuByMenuName(String menuName) {
		waitForElementVisible(driver, HomePageUI.MENU_BY_NAME, menuName);
		hoverToElement(driver, HomePageUI.MENU_BY_NAME, menuName);
	}

	public void openProductPageBySubmenu(String submenu) {
		waitForElementVisible(driver, HomePageUI.SUB_MENU_BY_NAME, submenu);
		hoverToElement(driver, HomePageUI.SUB_MENU_BY_NAME, submenu);
		clickToElement(driver, HomePageUI.SUB_MENU_BY_NAME, submenu);
	}

}
