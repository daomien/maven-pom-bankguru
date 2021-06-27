package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}

	public boolean isEmailConfirmationTextboxDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_CONFIRMATION_TEXTBOX);
	}

	public boolean isEmailConfirmationTextboxUnDisplayed() {
		waitForElementInvisible(driver, RegisterPageUI.EMAIL_CONFIRMATION_TEXTBOX);
		return isElementUnDisplayed(driver, RegisterPageUI.EMAIL_CONFIRMATION_TEXTBOX);
	}

	public boolean isLoginButtonUnDisplayed() {
		waitForElementInvisible(driver, RegisterPageUI.LOGIN_BUTTON);
		return isElementUnDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

}
