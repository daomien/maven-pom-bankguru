package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	public static BasePageFactory getBasePage() {
		return new BasePageFactory();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeouts);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();
	}

	public void sendKeysAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}

	public void switchToOtherWindow(WebDriver driver, String windowID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToMultipleWindow(WebDriver driver, String expectedWindowTitle) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualWindowTitle = driver.getTitle();
			if (actualWindowTitle.equals(expectedWindowTitle)) {
				break;
			}
		}
	}

	public void closeAllTabWithoutParentTab(WebDriver driver, String windowID) {

		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				driver.close();
				sleepInSeconds(2);
			}
		}
	}

	public void sleepInSeconds(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void sendKeysToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public Boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAllElementsVisible(WebDriver driver, List<WebElement> elements) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementInvisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	private Alert alert;
	private long timeouts;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
