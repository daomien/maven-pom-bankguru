package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static DashboardPageObject dashboardPage;
	private static LoginPageObject loginPage;
	private static SearchProductPageObject searchProductPage;
	private static EditProductDetailsPageObject editProductDetailsPage;

	private PageGeneratorManager() {
	}

	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPageObject(driver);
		}
		return dashboardPage;
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}

	public static SearchProductPageObject getSearchProductPage(WebDriver driver) {
		if (searchProductPage == null) {
			searchProductPage = new SearchProductPageObject(driver);
		}
		return searchProductPage;
	}

	public static EditProductDetailsPageObject getEditProductDetailsPage(WebDriver driver) {
		if (editProductDetailsPage == null) {
			editProductDetailsPage = new EditProductDetailsPageObject(driver);
		}
		return editProductDetailsPage;
	}

}
