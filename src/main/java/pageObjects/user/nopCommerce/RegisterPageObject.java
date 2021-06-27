package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Select Gender")
	public void clickOnGenderRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO_BUTTON);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO_BUTTON);
	}

	@Step("Enter first name textbox with value: {0}")
	public void enterToFirstNameTextbox(String username) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, username);
	}

	@Step("Enter last name textbox with value: {0}")
	public void enterToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastname);
	}

	@Step("Enter email textbox with value: {0}")
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Enter password textbox with value: {0}")
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);

	}
	
	@Step("Enter confirmation password textbox with value: {0}")
	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	@Step("Click on Register button")
	public void clickOnRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	@Step("Verify registered success message displayed")
	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	@Step("Click on Logout link")
	public HomePageObject clickOnLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}
