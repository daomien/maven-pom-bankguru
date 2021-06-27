package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

	public String getEmptyEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
	}

	public String getEmptyPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
	}

	public void enterToEmailTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, value);

	}

	public void enterToPasswordTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, value);

	}

	public String getInvalidEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	}

	public String getInvalidPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
	}

	public String getIncorrectEmaiOrPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.INCORRECT_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INCORRECT_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
	}
}
