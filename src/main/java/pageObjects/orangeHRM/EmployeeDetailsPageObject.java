package pageObjects.orangeHRM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangeHRM.EmployeeDetailsPageUI;

public class EmployeeDetailsPageObject extends BasePage {
	WebDriver driver;

	public EmployeeDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextboxAtAddEmployeeForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, firstName);
	}

	public void enterToLastNameTextboxAtAddEmployeeForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, lastName);
	}

	public String getEmployeeIDAtAddEmployeeForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.EMPLOYEEID_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		return getElementAttributeValue(driver, EmployeeDetailsPageUI.EMPLOYEEID_TEXTBOX_AT_ADD_EMPLOYEE_FORM, "value");
	}

	public boolean isFullNameDisplayedAtHeader(String fullName) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.FULLNAME_TEXT_AT_PERSONAL_DETAILS_FORM, fullName);
		return isElementDisplayed(driver, EmployeeDetailsPageUI.FULLNAME_TEXT_AT_PERSONAL_DETAILS_FORM, fullName);
	}

	public String getFirstNameValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM);
		return getElementAttributeValue(driver, EmployeeDetailsPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM, "value");
	}

	public String getLastNameValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM);
		return getElementAttributeValue(driver, EmployeeDetailsPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM, "value");
	}

	public String getEmployeeValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.EMPLOYEEID_TEXT_AT_PERSONAL_DETAILS_FORM);
		return getElementAttributeValue(driver, EmployeeDetailsPageUI.EMPLOYEEID_TEXT_AT_PERSONAL_DETAILS_FORM, "value");
	}

	public void enterToFirstNameTextboxAtPersonalDetailsForm(String editFirstName) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM, editFirstName);
	}

	public void enterToLastNameTextboxAtPersonalDetailsForm(String editLastName) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM, editLastName);
	}

	public void enterToSSNNumberTextboxAtPersonalDetailsForm(String editSSNNumber) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.SSNNUMBER_TEXTBOX_AT_PERSONAL_DETAILS_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.SSNNUMBER_TEXTBOX_AT_PERSONAL_DETAILS_FORM, editSSNNumber);
	}

	public void selectGenderRadioAtPersonalDetailsForm(String editGender) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAILS_FORM, editGender);
		checkToCheckboxOrRadio(driver, EmployeeDetailsPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAILS_FORM, editGender);
	}

	public void selectMaritalStatusDropdownAtPersonalDetailsForm(String editMaritalStatus) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAILS_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAILS_FORM, editMaritalStatus);
	}

	public void selectNationalityDropdownAtPersonalDetailsForm(String editNationality) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAILS_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAILS_FORM, editNationality);
	}

	public void enterToDOBTextboxAtPersonalDetailsForm(String editDOB) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.DOB_TEXTBOX_AT_PERSONAL_DETAILS_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.DOB_TEXTBOX_AT_PERSONAL_DETAILS_FORM, editDOB);
	}

	public String isSavedSuccessfullyDisplayed() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.SUCCESS_MESSAGE_TEXT);
		return getElementText(driver, EmployeeDetailsPageUI.SUCCESS_MESSAGE_TEXT);
	}

	public String getSSNNumberValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.SSNNUMBER_TEXTBOX_AT_PERSONAL_DETAILS_FORM);
		return getElementAttributeValue(driver, EmployeeDetailsPageUI.SSNNUMBER_TEXTBOX_AT_PERSONAL_DETAILS_FORM, "value");
	}

	public boolean isGenderRadioButtonSelected(String genderValue) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAILS_FORM, genderValue);
		return isElementSelected(driver, EmployeeDetailsPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAILS_FORM, genderValue);
	}

	public String getMaritalStatusValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAILS_FORM);
		return getSelectedItemDropdown(driver, EmployeeDetailsPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAILS_FORM);
	}

	public String getNationalityValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAILS_FORM);
		return getSelectedItemDropdown(driver, EmployeeDetailsPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAILS_FORM);
	}

	public String getDOBValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.DOB_TEXTBOX_AT_PERSONAL_DETAILS_FORM);
		return getElementAttributeValue(driver, EmployeeDetailsPageUI.DOB_TEXTBOX_AT_PERSONAL_DETAILS_FORM, "value");
	}

	public void selectPayGradeDropdownAtAddSalaryForm(String payGrade) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.PAY_GRADE_DROPDOWN_AT_ADD_SALARY_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.PAY_GRADE_DROPDOWN_AT_ADD_SALARY_FORM, payGrade);
	}

	public void enterToSalaryComponentTextboxAtAddSalaryForm(String salaryComponent) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.SALARY_COMPONENT_TEXTBOX_AT_ADD_SALARY_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.SALARY_COMPONENT_TEXTBOX_AT_ADD_SALARY_FORM, salaryComponent);
	}

	public void selectPayFrequencyDropdownAtAddSalaryForm(String payFrequency) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.PAY_FREQUENCY_DROPDOWN_AT_ADD_SALARY_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.PAY_FREQUENCY_DROPDOWN_AT_ADD_SALARY_FORM, payFrequency);
	}

	public void selectCurrencyDropdownAtAddSalaryForm(String currency) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.CURRENCY_DROPDOWN_AT_ADD_SALARY_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.CURRENCY_DROPDOWN_AT_ADD_SALARY_FORM, currency);
	}

	public void enterToAmountTextboxAtAddSalaryForm(String amount) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.AMOUNT_TEXTBOX_AT_ADD_SALARY_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.AMOUNT_TEXTBOX_AT_ADD_SALARY_FORM, amount);
	}

	public void enterToCommentTextboxAtAddSalaryForm(String comment) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.COMMENT_TEXTBOX_AT_ADD_SALARY_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.COMMENT_TEXTBOX_AT_ADD_SALARY_FORM, comment);
	}

	public void selectJobTitleDropdownAtPersonalDetailsForm(String jobTitle) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.JOB_TITLE_DROPDOWN_AT_JOB_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.JOB_TITLE_DROPDOWN_AT_JOB_FORM, jobTitle);
	}

	public void selectEmploymentStatusDropdownAtPersonalDetailsForm(String employmentStatus) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.EMPLOYEMENT_STATUS_DROPDOWN_AT_JOB_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.EMPLOYEMENT_STATUS_DROPDOWN_AT_JOB_FORM, employmentStatus);
	}

	public void selectJobCategoryDropdownAtPersonalDetailsForm(String jobCategory) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.JOB_CATEGORY_DROPDOWN_AT_JOB_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.JOB_CATEGORY_DROPDOWN_AT_JOB_FORM, jobCategory);
	}

	public void enterToJoinedDateTextboxAtPersonalDetailsForm(String joinedDate) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.JOINED_DATE_TEXTBOX_AT_ADD_SALARY_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.JOINED_DATE_TEXTBOX_AT_ADD_SALARY_FORM, joinedDate);
	}

	public void selectSubUnitDropdownAtPersonalDetailsForm(String subUnit) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.SUB_UNIT_DROPDOWN_AT_JOB_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.SUB_UNIT_DROPDOWN_AT_JOB_FORM, subUnit);
	}

	public void selectLocationDropdownAtPersonalDetailsForm(String location) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.LOCATION_DROPDOWN_AT_JOB_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.LOCATION_DROPDOWN_AT_JOB_FORM, location);
	}

	public void enterToStartDateTextboxAtPersonalDetailsForm(String startDate) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.START_DATE_TEXTBOX_AT_ADD_SALARY_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.START_DATE_TEXTBOX_AT_ADD_SALARY_FORM, startDate);
	}

	public void enterToEndDateTextboxAtPersonalDetailsForm(String endDate) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.END_DATE_TEXTBOX_AT_ADD_SALARY_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.END_DATE_TEXTBOX_AT_ADD_SALARY_FORM, endDate);
	}

	public String getJobTitleValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.JOB_TITLE_DROPDOWN_AT_JOB_FORM);
		return getSelectedItemDropdown(driver, EmployeeDetailsPageUI.JOB_TITLE_DROPDOWN_AT_JOB_FORM);
	}

	public String getEmploymentStatusValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.EMPLOYEMENT_STATUS_DROPDOWN_AT_JOB_FORM);
		return getSelectedItemDropdown(driver, EmployeeDetailsPageUI.EMPLOYEMENT_STATUS_DROPDOWN_AT_JOB_FORM);
	}

	public String getJobCategoryValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.JOB_CATEGORY_DROPDOWN_AT_JOB_FORM);
		return getSelectedItemDropdown(driver, EmployeeDetailsPageUI.JOB_CATEGORY_DROPDOWN_AT_JOB_FORM);
	}

	public String getJoinedDateValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.JOINED_DATE_TEXTBOX_AT_ADD_SALARY_FORM);
		return getElementAttributeValue(driver, EmployeeDetailsPageUI.JOINED_DATE_TEXTBOX_AT_ADD_SALARY_FORM, "value");
	}

	public Object getSubUnitValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.SUB_UNIT_DROPDOWN_AT_JOB_FORM);
		return getSelectedItemDropdown(driver, EmployeeDetailsPageUI.SUB_UNIT_DROPDOWN_AT_JOB_FORM);
	}

	public Object getLocationValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.LOCATION_DROPDOWN_AT_JOB_FORM);
		return getSelectedItemDropdown(driver, EmployeeDetailsPageUI.LOCATION_DROPDOWN_AT_JOB_FORM);
	}

	public String getStartDateValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.START_DATE_TEXTBOX_AT_ADD_SALARY_FORM);
		return getElementAttributeValue(driver, EmployeeDetailsPageUI.START_DATE_TEXTBOX_AT_ADD_SALARY_FORM, "value");
	}

	public Object getEndDateValueAtPersonalDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailsPageUI.END_DATE_TEXTBOX_AT_ADD_SALARY_FORM);
		return getElementAttributeValue(driver, EmployeeDetailsPageUI.END_DATE_TEXTBOX_AT_ADD_SALARY_FORM, "value");
	}

	public void enterToNameSupervisorTextboxAtAddSupervisorForm(String namSupervisor) {
		waitForElementVisible(driver, EmployeeDetailsPageUI.NAME_SUPERVISOR_TEXTBOX_AT_ADD_SALARY_FORM);
		clickToElement(driver, EmployeeDetailsPageUI.NAME_SUPERVISOR_TEXTBOX_AT_ADD_SALARY_FORM);
		sendKeysToElement(driver, EmployeeDetailsPageUI.NAME_SUPERVISOR_TEXTBOX_AT_ADD_SALARY_FORM, namSupervisor);
		sleepInSeconds(1);
		pressKeyElement(driver, EmployeeDetailsPageUI.NAME_SUPERVISOR_TEXTBOX_AT_ADD_SALARY_FORM, Keys.TAB);		
	}

	public void selectReportingMethodDropdownAtAddSupervisorForm(String reportingMethod) {
		waitForElementClickable(driver, EmployeeDetailsPageUI.REPORTING_METHOD_DROPDOWN_AT_JOB_FORM);
		selectDropdownByText(driver, EmployeeDetailsPageUI.REPORTING_METHOD_DROPDOWN_AT_JOB_FORM, reportingMethod);
	}
}
