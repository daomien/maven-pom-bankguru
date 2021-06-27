package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;
	@FindBy(id = "gender-male")
	WebElement genderMaleRadioButton;

	@FindBy(id = "gender-female")
	WebElement genderFemaleRadioButton;

	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	WebElement lastNameTextbox;

	@FindBy(id = "Email")
	WebElement emailTextbox;

	@FindBy(id = "Password")
	WebElement passwordTextbox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextbox;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;

	@FindBy(css = ".ico-logout")
	WebElement logoutLink;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnGenderRadioButton() {
		waitForElementClickable(driver, genderMaleRadioButton);
		clickToElement(driver, genderMaleRadioButton);
	}

	public void enterToFirstNameTextbox(String username) {
		waitForElementInvisible(driver, firstNameTextbox);
		clickToElement(driver, firstNameTextbox);
	}

	public void enterToLastNameTextbox(String lastname) {
		waitForElementInvisible(driver, lastNameTextbox);
		clickToElement(driver, lastNameTextbox);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementInvisible(driver, emailTextbox);
		clickToElement(driver, emailTextbox);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementInvisible(driver, passwordTextbox);
		clickToElement(driver, passwordTextbox);

	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementInvisible(driver, confirmPasswordTextbox);
		clickToElement(driver, confirmPasswordTextbox);
	}

	public void clickOnRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public boolean isSuccessMessageDisplayed() {
		return isElementDisplayed(driver, successMessage);
	}

	public void clickOnLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

}
