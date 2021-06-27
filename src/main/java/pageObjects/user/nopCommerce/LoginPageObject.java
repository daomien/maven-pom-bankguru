package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Enter email with value: {0}")
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Enter password with value: {0}")
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Click on Login button")
	public HomePageObject clickOnLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public HomePageObject clickOnLogoHomepage() {
		waitForElementClickable(driver, LoginPageUI.IMG_LOGO);
		clickToElement(driver, LoginPageUI.IMG_LOGO);
		return PageGeneratorManager.getHomePage(driver);
	}

}
