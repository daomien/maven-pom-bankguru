package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_Login_Repeat_Yourself {

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
	}

	@Test
	public void Login_01_Register_To_System() {
		getLoginPageURL = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.name("emailid")).sendKeys(getEmailRandom());
		driver.findElement(By.name("btnLogin")).click();
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}

	@Test
	public void Login_02_Login_To_System() {
		driver.get(getLoginPageURL);
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(), "Welcome To Manager's Page of Guru99 Bank");

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
