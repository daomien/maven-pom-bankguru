package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	WebDriver driver;

	@FindBy(id = "Email")
	WebElement emailTextbox;

	@FindBy(id = "Password")
	WebElement passwordTextbox;

	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	WebElement loginButton;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterToEmailTextbox(String email) {
		isElementDisplayed(driver, emailTextbox);
		sendKeysToElement(driver, emailTextbox, email);
	}

	public void enterToPasswordTextbox(String password) {
		isElementDisplayed(driver, passwordTextbox);
		sendKeysToElement(driver, passwordTextbox, password);
	}

	public void clickOnLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}
