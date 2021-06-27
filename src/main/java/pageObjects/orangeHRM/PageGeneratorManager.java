package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	private PageGeneratorManager() {
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}

	public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPageObject(driver);
	}

	public static EmployeeDetailsPageObject getEmployeeDetailsPage(WebDriver driver) {
		return new EmployeeDetailsPageObject(driver);
	}

}
