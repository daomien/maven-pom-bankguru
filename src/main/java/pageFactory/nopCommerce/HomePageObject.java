package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;


public class HomePageObject extends BasePageFactory {
	private WebDriver driver;

	@FindBy(id = "nivo-slider")
	WebElement homepageSlider;

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(className = "ico-login")
	WebElement loginLink;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isHomePageSliderDisplayed() {
		return isElementDisplayed(driver, homepageSlider);
	}

	public void clickOnRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickOnLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
