package commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.SearchPageObject;
import pageObjects.user.nopCommerce.ShippingAndReturnPageObject;
import pageObjects.user.nopCommerce.SiteMapPageObject;
import pageObjects.user.nopCommerce.WishlistHeaderPageObject;
import pageUIs.admin.nopCommerce.AdminBasePageUI;
import pageUIs.orangeHRM.EmployeeBasePageUI;
import pageUIs.user.nopCommerce.UserBasePageUI;

public class BasePage {

    public static BasePage getBasePage() {
        return new BasePage();
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

    public Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
        for (Cookie cookie : allCookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, longTimeouts);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        alert = waitForAlertPresence(driver);
        alert.accept();
        sleepInSeconds(2);
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

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public WebElement getElement(WebDriver driver, String locator, String... params) {
        return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
    }

    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);

    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public String getDynamicLocator(String locator, String... params) {
        return String.format(locator, (Object[]) params);
    }

    public void clickToElement(WebDriver driver, String locator, String... params) {
        getElement(driver, getDynamicLocator(locator, params)).click();
    }

    public void sendKeysToElement(WebDriver driver, String locator, String value) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    public void sendKeysToElement(WebDriver driver, String locator, String value, String... params) {
        getElement(driver, getDynamicLocator(locator, params)).clear();
        getElement(driver, getDynamicLocator(locator, params)).sendKeys(value);
    }

    public int getElementSize(WebDriver driver, String locator) {
        return getElements(driver, locator).size();
    }

    public int getElementSize(WebDriver driver, String locator, String... params) {
        locator = getDynamicLocator(locator, params);
        return getElements(driver, locator).size();
    }

    public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
        select = new Select(getElement(driver, locator));
        select.selectByVisibleText(itemText);
    }

    public String getSelectedItemDropdown(WebDriver driver, String locator) {
        select = new Select(getElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    public Boolean isDropdownMultiple(WebDriver driver, String locator) {
        select = new Select(getElement(driver, locator));
        return select.isMultiple();

    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSeconds(1);

        explicitWait = new WebDriverWait(driver, longTimeouts);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSeconds(1);

                item.click();
                sleepInSeconds(1);
                break;
            }
        }
    }

    public String getElementAttributeValue(WebDriver driver, String locator, String value) {
        return getElement(driver, locator).getAttribute(value);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText().trim();
    }

    public String getElementText(WebDriver driver, String locator, String... params) {
        return getElement(driver, getDynamicLocator(locator, params)).getText().trim();
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
        if (!isElementSelected(driver, locator)) {
            getElement(driver, locator).click();
        }
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... params) {
        locator = getDynamicLocator(locator, params);
        if (!isElementSelected(driver, locator)) {
            getElement(driver, locator).click();
        }
    }

    public void uncheckToCheckbox(WebDriver driver, String locator) {
        if (isElementSelected(driver, locator)) {
            getElement(driver, locator).click();
        }
    }

    public Boolean isElementDisplayed(WebDriver driver, String locator) {
        try {
            // Displayed: Visible on UI + in DOM
            // Displayed: Invisible on UI + in DOM
            return getElement(driver, locator).isDisplayed();
        } catch (Exception e) {
            // Undisplayed: Invisible on UI + NOT in DOM
            return false;
        }
    }

    public Boolean isElementUnDisplayed(WebDriver driver, String locator) {
        System.out.println("Start time === " + new Date().toString());
        overrideGlobaleTimeout(driver, shortTimeouts);
        List<WebElement> elements = getElements(driver, locator);
        overrideGlobaleTimeout(driver, longTimeouts);
        if (elements.size() == 0) {
            System.out.println("Element not in DOM");
            System.out.println("End time === " + new Date().toString());
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Element in DOM but not visible/displayed");
            System.out.println("End time === " + new Date().toString());
            return true;
        } else {
            System.out.println("Element in DOM and visible");
            return false;
        }
    }

    public Boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
        return getElement(driver, getDynamicLocator(locator, params)).isDisplayed();
    }

    public Boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public Boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public Boolean isElementSelected(WebDriver driver, String locator, String... params) {
        locator = getDynamicLocator(locator, params);
        return getElement(driver, locator).isSelected();
    }

    public WebDriver switchToIframByElement(WebDriver driver, String locator) {
        return driver.switchTo().frame(getElement(driver, locator));
    }

    public WebDriver switchToDefaultContent(WebDriver driver, String locator) {
        return driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.moveToElement(getElement(driver, locator)).perform();
    }

    public void hoverToElement(WebDriver driver, String locator, String... params) {
        action = new Actions(driver);
        locator = getDynamicLocator(locator, params);
        action.moveToElement(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.doubleClick(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        action = new Actions(driver);
        action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void pressKeyElement(WebDriver driver, String locator, Keys key) {
        action = new Actions(driver);
        action.sendKeys(getElement(driver, locator), key).perform();
    }

    public void pressKeyElement(WebDriver driver, String locator, Keys key, String... params) {
        action = new Actions(driver);
        locator = getDynamicLocator(locator, params);
        action.sendKeys(getElement(driver, locator), key).perform();
    }

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElement(WebDriver driver, String locator, String... params) {
        jsExecutor = (JavascriptExecutor) driver;
        locator = getDynamicLocator(locator, params);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, longTimeouts);
        jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeouts);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... params) {
        explicitWait = new WebDriverWait(driver, longTimeouts);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
    }

    public void waitForAllElementsVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeouts);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public void waitForAllElementsVisible(WebDriver driver, String locator, String... params) {
        explicitWait = new WebDriverWait(driver, longTimeouts);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(getDynamicLocator(locator, params))));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeouts);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... params) {
        explicitWait = new WebDriverWait(driver, longTimeouts);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, shortTimeouts);
        overrideGlobaleTimeout(driver, shortTimeouts);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
        overrideGlobaleTimeout(driver, longTimeouts);
    }

    public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
        explicitWait = new WebDriverWait(driver, shortTimeouts);
        overrideGlobaleTimeout(driver, shortTimeouts);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
        overrideGlobaleTimeout(driver, longTimeouts);
    }

    public void overrideGlobaleTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    // User - nopcommerce
    public SearchPageObject openSearchPage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.SEARCH_FOOTER_LINK);
        clickToElement(driver, UserBasePageUI.SEARCH_FOOTER_LINK);
        return PageGeneratorManager.getSearchPage(driver);
    }

    public WishlistHeaderPageObject openWishListPage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.WISHLIST_HEADER_LINK);
        clickToElement(driver, UserBasePageUI.WISHLIST_HEADER_LINK);
        return PageGeneratorManager.getWishlistHeaderPage(driver);
    }

    public ShippingAndReturnPageObject openShippingAndReturnPage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.SHIPPING_AND_RETURN_FOOTER_LINK);
        clickToElement(driver, UserBasePageUI.SHIPPING_AND_RETURN_FOOTER_LINK);
        return PageGeneratorManager.getShippingAndReturnPage(driver);
    }

    public SiteMapPageObject openSiteMapPage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.SITE_MAP_FOOTER_LINK);
        clickToElement(driver, UserBasePageUI.SITE_MAP_FOOTER_LINK);
        return PageGeneratorManager.getSiteMapePage(driver);
    }

    public MyAccountPageObject openMyAccountFooterPage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.MY_ACCOUNT_FOOTER_LINK);
        clickToElement(driver, UserBasePageUI.MY_ACCOUNT_FOOTER_LINK);
        return PageGeneratorManager.getMyAccountPage(driver);
    }

    public HomePageObject openHomePage(WebDriver driver) {
        waitForElementVisible(driver, UserBasePageUI.HOMEPAGE_LOGO);
        clickToElement(driver, UserBasePageUI.HOMEPAGE_LOGO);
        return PageGeneratorManager.getHomePage(driver);
    }

    public BasePage getFooterPageByName(WebDriver driver, String pageName) {
        waitForElementVisible(driver, UserBasePageUI.DYNAMIC_MY_ACCOUNT_FOOTER_LINK, pageName);
        clickToElement(driver, UserBasePageUI.DYNAMIC_MY_ACCOUNT_FOOTER_LINK, pageName);
        if (pageName.equalsIgnoreCase("Search")) {
            return PageGeneratorManager.getSearchPage(driver);
        } else if (pageName.equalsIgnoreCase("Shipping & returns")) {
            return PageGeneratorManager.getShippingAndReturnPage(driver);
        } else if (pageName.equalsIgnoreCase("Sitemap")) {
            return PageGeneratorManager.getSiteMapePage(driver);
        } else {
            return PageGeneratorManager.getMyAccountPage(driver);
        }
    }

    public void openFooterPageByName(WebDriver driver, String pageName) {
        waitForElementVisible(driver, UserBasePageUI.DYNAMIC_MY_ACCOUNT_FOOTER_LINK, pageName);
        clickToElement(driver, UserBasePageUI.DYNAMIC_MY_ACCOUNT_FOOTER_LINK, pageName);
    }

    // Admin - Nopcommerce
    public void openProductsPage(WebDriver driver, String menuName, String subMenuName) {
        waitForElementClickable(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuName);
        clickToElement(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuName);
        waitForElementClickable(driver, AdminBasePageUI.SUBMENU_LINK_BY_NAME, subMenuName);
        clickToElement(driver, AdminBasePageUI.SUBMENU_LINK_BY_NAME, subMenuName);
    }

    public void uploadFileByCardName(WebDriver driver, String cardName, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_IMAGE_FOLDER_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, AdminBasePageUI.UPLOAD_FILE_BUTTON_BY_CARD_NAME, cardName).sendKeys(fullFileName);
    }

    public boolean isEmptyMessageInTableDisplayedByCardName(WebDriver driver, String cardName) {
        waitForElementVisible(driver, AdminBasePageUI.EMPTY_MESSAGE_IN_TABLE_BY_CARD_NAME, cardName);
        return isElementDisplayed(driver, AdminBasePageUI.EMPTY_MESSAGE_IN_TABLE_BY_CARD_NAME, cardName);
    }

    public void clickOnHeaderLinkByName(WebDriver driver, String linkName) {
        waitForElementClickable(driver, UserBasePageUI.HEADER_LINK_BY_NAME, linkName);
        clickToElement(driver, UserBasePageUI.HEADER_LINK_BY_NAME, linkName);
    }

    public void enterToTextboxById(WebDriver driver, String value, String textboxId) {
        waitForElementVisible(driver, UserBasePageUI.TEXTBOX_BY_ID, textboxId);
        sendKeysToElement(driver, UserBasePageUI.TEXTBOX_BY_ID, value, textboxId);
    }

    public void clickOnButtonByName(WebDriver driver, String buttonName) {
        waitForElementClickable(driver, UserBasePageUI.BUTTON_BY_NAME, buttonName);
        clickToElement(driver, UserBasePageUI.BUTTON_BY_NAME, buttonName);
    }

    // OrangeHRM - Project

    public void openMenuPageByName(WebDriver driver, String menuName) {
        waitForElementVisible(driver, EmployeeBasePageUI.DYNAMIC_MENU_BY_NAME, menuName);
        clickToElement(driver, EmployeeBasePageUI.DYNAMIC_MENU_BY_NAME, menuName);
    }

    public void clickOnButtonByNameAtHeaderForm(WebDriver driver, String headerName, String buttonName) {
        waitForElementClickable(driver, EmployeeBasePageUI.DYNAMIC_BUTTON_BY_NAME_AT_HEADER_FORM, headerName, buttonName);
        clickToElement(driver, EmployeeBasePageUI.DYNAMIC_BUTTON_BY_NAME_AT_HEADER_FORM, headerName, buttonName);
    }

    public void openSidebarTabByName(WebDriver driver, String sidebarName) {
        waitForElementClickable(driver, EmployeeBasePageUI.DYNAMIC_SIDEBAR_BY_NAME, sidebarName);
        clickToElement(driver, EmployeeBasePageUI.DYNAMIC_SIDEBAR_BY_NAME, sidebarName);
    }

    public boolean isInformationDisplayedAtColumnNameAndRowNumber(WebDriver driver, String tableID, String columnName, String rowIndex, String expectedValue) {
        int columnNumber = getElementSize(driver, EmployeeBasePageUI.DYNAMIC_TABLE_COLUMN_NAME, tableID, columnName) + 1;
        String actualValue = getElementText(driver, EmployeeBasePageUI.CELL_VALUE_BY_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnNumber));
        return actualValue.equals(expectedValue);
    }

    public boolean isNoRecordFoundByTableID(WebDriver driver, String tableID) {
        waitForElementVisible(driver, EmployeeBasePageUI.NO_RECORD_FOUND_BY_TABLE_ID, tableID);
        return isElementDisplayed(driver, EmployeeBasePageUI.NO_RECORD_FOUND_BY_TABLE_ID, tableID);
    }

    // User - nopcommerce
    public boolean isDataStringSortedByAscending(WebDriver driver, String locator) {
        // Create a array list
        ArrayList<String> arrList = new ArrayList<>();

        // get all elements by product name or price, date...
        List<WebElement> elementList = driver.findElements(By.xpath(locator));

        // get text of all elements
        for (WebElement el : elementList) {
            arrList.add(el.getText());
        }

        System.out.println("arrList");
        System.out.println(arrList);

        // Copy to 1 array list to sort
        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrList) {
            sortedList.add(child);
        }

        // sort by ASC
        Collections.sort(sortedList);


        System.out.println("sortedList");
        System.out.println(sortedList);
        // Compare 2 list
        return sortedList.equals(arrList);
    }

    public boolean isDataStringSortedByDescending(WebDriver driver, String locator) {
        // Create a array list
        ArrayList<String> arrList = new ArrayList<>();

        // get all elements by product name or price, date...
        List<WebElement> elementList = driver.findElements(By.xpath(locator));

        // get text of all elements
        for (WebElement el : elementList) {
            arrList.add(el.getText());
        }

        // Copy to 1 array list to sort
        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrList) {
            sortedList.add(child);
        }

        // sort by ASC
        Collections.sort(sortedList);

        // Reverse to DESC
        Collections.reverse(sortedList);

        // Compare 2 list
        return sortedList.equals(arrList);
    }


    public boolean isDataFloatSortedByAscending(WebDriver driver, String locator) {
        // Create a array list
        ArrayList<Float> arrList = new ArrayList<Float>();

        // get all elements by product name or price, date...
        List<WebElement> elementList = driver.findElements(By.xpath(locator));

        // get text of all elements
        for (WebElement el : elementList) {
            arrList.add(Float.parseFloat(el.getText().replace("$", "").trim().replace(",", "")));
        }

        // Copy to 1 array list to sort
        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrList) {
            sortedList.add(child);
        }

        // sort by ASC
        Collections.sort(sortedList);

        // Compare 2 list
        return sortedList.equals(arrList);
    }


    public boolean isDataFloatSortedByDescending(WebDriver driver, String locator) {
        // Create a array list
        ArrayList<Float> arrList = new ArrayList<Float>();

        // get all elements by product name or price, date...
        List<WebElement> elementList = driver.findElements(By.xpath(locator));

        // get text of all elements
        for (WebElement el : elementList) {
            arrList.add(Float.parseFloat(el.getText().replace("$", "").trim().replace(",", "")));
        }

        // Copy to 1 array list to sort
        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrList) {
            sortedList.add(child);
        }

        // sort by ASC
        Collections.sort(sortedList);

        // sort by DESC
        Collections.reverse(sortedList);

        // Compare 2 list
        return sortedList.equals(arrList);
    }

    private Alert alert;
    private long shortTimeouts = GlobalConstants.SHORT_TIMEOUT;
    private long longTimeouts = GlobalConstants.LONG_TIMEOUT;
    private Select select;
    private Actions action;
    private WebDriverWait explicitWait;
    private JavascriptExecutor jsExecutor;
}
