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

public class Level_02_Register_Login_BasePage_P1 {

	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String userID, password;
	String getLoginPageURL;
	BasePage basePage;

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		basePage = new BasePage();
	}

	@Test
	public void Login_01_Register_To_System() {
		getLoginPageURL = driver.getCurrentUrl();
		basePage.clickToElement(driver, "//a[text()='here']");
		basePage.sendKeysToElement(driver, "//input[@name='emailid']", getEmailRandom());
		basePage.clickToElement(driver, "//input[@name='btnLogin']");

		userID = basePage.getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = basePage.getElementText(driver, "//td[text()='Password :']/following-sibling::td");
	}

	@Test
	public void Login_02_Login_To_System() {
		driver.get(getLoginPageURL);
		basePage.sendKeysToElement(driver, "//input[@name='uid']", userID);
		basePage.sendKeysToElement(driver, "//input[@name='password']", password);
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		Assert.assertEquals(basePage.getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");

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
