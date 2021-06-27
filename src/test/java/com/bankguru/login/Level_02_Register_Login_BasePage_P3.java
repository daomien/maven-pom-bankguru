package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_BasePage_P3 extends BasePage {

	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String userID, password;
	String getLoginPageURL;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		getLoginPageURL = driver.getCurrentUrl();
	}


	@Test
	public void Login_01_Register_To_System() {
		getLoginPageURL = driver.getCurrentUrl();
		clickToElement(driver, "//a[text()='here']");
		sendKeysToElement(driver, "//input[@name='emailid']", getEmailRandom());
		clickToElement(driver, "//input[@name='btnLogin']");

		userID = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");
	}

	@Test
	public void Login_02_Login_To_System() {
		driver.get(getLoginPageURL);
		sendKeysToElement(driver, "//input[@name='uid']", userID);
		sendKeysToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");
	}


	public String getEmailRandom() {
		Random rand = new Random();
		return "testing" + rand.nextInt(999) + "@gmail.com";
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
