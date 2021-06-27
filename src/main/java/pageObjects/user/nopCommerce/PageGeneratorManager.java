package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static SearchPageObject searchPage;
	private static ShippingAndReturnPageObject shippingAndReturnPage;
	private static SiteMapPageObject siteMapPage;
	private static MyAccountPageObject myAccountPage;
	private static WishlistHeaderPageObject wishlistHeaderPage;

	private PageGeneratorManager() {
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static ComputerPageObject getComputerPage(WebDriver driver) {
		return new ComputerPageObject(driver);
	}

	public static SearchPageObject getSearchPage(WebDriver driver) {
		if (searchPage == null) {
			searchPage = new SearchPageObject(driver);
		}
		return searchPage;
	}

	public static ShippingAndReturnPageObject getShippingAndReturnPage(WebDriver driver) {
		if (shippingAndReturnPage == null) {
			shippingAndReturnPage = new ShippingAndReturnPageObject(driver);
		}
		return shippingAndReturnPage;
	}

	public static SiteMapPageObject getSiteMapePage(WebDriver driver) {
		if (siteMapPage == null) {
			siteMapPage = new SiteMapPageObject(driver);
		}
		return siteMapPage;
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		if (myAccountPage == null) {
			myAccountPage = new MyAccountPageObject(driver);
		}
		return myAccountPage;
	}

	public static WishlistHeaderPageObject getWishlistHeaderPage(WebDriver driver) {
		if (wishlistHeaderPage == null) {
			wishlistHeaderPage = new WishlistHeaderPageObject(driver);
		}
		return wishlistHeaderPage;
	}

}
