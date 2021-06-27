package pageObjects.orangeHRM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.EmployeeListPageUI;

public class EmployeeListPageObject extends BasePage {
	WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EmployeeDetailsPageObject clickOnAddButtonAtEmployeeListPage() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON_AT_EMPLOYEE_LIST);
		clickToElement(driver, EmployeeListPageUI.ADD_BUTTON_AT_EMPLOYEE_LIST);
		return PageGeneratorManager.getEmployeeDetailsPage(driver);
	}

	public void enterToEmployeeNameTextboxAtEmployeeInformationForm(String employeeName) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX_AT_EMPLOYEE_LIST);
		clickToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX_AT_EMPLOYEE_LIST);
		sendKeysToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX_AT_EMPLOYEE_LIST, employeeName);
		sleepInSeconds(2);
		pressKeyElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX_AT_EMPLOYEE_LIST, Keys.TAB);
		sleepInSeconds(1);
	}

	public void enterToEmployeeIDTextboxAtEmployeeInformationForm(String employeeID) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX_AT_EMPLOYEE_LIST);
		sendKeysToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX_AT_EMPLOYEE_LIST, employeeID);
	}

	public void selectEmploymentStatusAtEmployeeInformationForm(String employmentStatus) {
		waitForElementClickable(driver, EmployeeListPageUI.EMPLOYMENT_STATUS_DROPDOWN_AT_EMPLOYEE_LIST);
		selectDropdownByText(driver, EmployeeListPageUI.EMPLOYMENT_STATUS_DROPDOWN_AT_EMPLOYEE_LIST, employmentStatus);
	}

	public void selectIncludeAtEmployeeInformationForm(String includeValue) {
		waitForElementClickable(driver, EmployeeListPageUI.INCLUDE_DROPDOWN_AT_EMPLOYEE_LIST);
		selectDropdownByText(driver, EmployeeListPageUI.INCLUDE_DROPDOWN_AT_EMPLOYEE_LIST, includeValue);
	}

	public void enterToSupervisorNameTextboxAtEmployeeInformationForm(String nameSupervisor) {
		waitForElementVisible(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX_AT_EMPLOYEE_LIST);
		clickToElement(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX_AT_EMPLOYEE_LIST);
		sendKeysToElement(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX_AT_EMPLOYEE_LIST, nameSupervisor);
		sleepInSeconds(2);
		pressKeyElement(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX_AT_EMPLOYEE_LIST, Keys.TAB);
		sleepInSeconds(1);
	}

	public void selectJobTitleAtEmployeeInformationForm(String jobTitle) {
		waitForElementClickable(driver, EmployeeListPageUI.JOB_TITLE_DROPDOWN_AT_EMPLOYEE_LIST);
		selectDropdownByText(driver, EmployeeListPageUI.JOB_TITLE_DROPDOWN_AT_EMPLOYEE_LIST, jobTitle);
	}

	public void selectSubUnitAtEmployeeInformationForm(String subUnit) {
		waitForElementClickable(driver, EmployeeListPageUI.SUB_UNIT_DROPDOWN_AT_EMPLOYEE_LIST);
		selectDropdownByText(driver, EmployeeListPageUI.SUB_UNIT_DROPDOWN_AT_EMPLOYEE_LIST, subUnit);
	}

}
