package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String valueEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, valueEmail);
	}

	public void inputToPasswordTextbox(String valuePassword) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, valuePassword);

	}

	public DashboardPageObject clickOnLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPage(driver);
	}
}
