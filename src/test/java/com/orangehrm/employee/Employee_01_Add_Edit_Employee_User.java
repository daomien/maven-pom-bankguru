package com.orangehrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.EmployeeDetailsPageObject;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.PageGeneratorManager;

public class Employee_01_Add_Edit_Employee_User extends BaseTest {

	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	EmployeeListPageObject employeeListPage;
	EmployeeDetailsPageObject employeeDetailsPage;
	String firstName, lastName, employeeID;
	String editFirstName, editLastName, editSSNNumber, editGender, editMaritalStatus, editNationality, editDOB;
	String payGrade, salaryComponent, payFrequency, currency, amount, comment;
	String jobTitle, employmentStatus, jobCategory, joinedDate, subUnit, location, startDate, endDate;
	String nameSupervisor, reportingMethod;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		log.info("Pre-condition: Initial browser driver");
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		firstName = "Automation " + getIntRandom();
		lastName = "Testing " + getIntRandom();

		editFirstName = "Manual " + getIntRandom();
		editLastName = "Test " + getIntRandom();
		editSSNNumber = "252-260";
		editGender = "Male";
		editMaritalStatus = "Single";
		editNationality = "Vietnamese";
		editDOB = "1993-05-22";

		payGrade = "Grade 1";
		salaryComponent = "SC123456";
		payFrequency = "Monthly on first pay of month.";
		currency = "United States Dollar";
		amount = "58990";
		comment = "Auto add salary component.";

		jobTitle = "QA Engineer";
		employmentStatus = "Full-Time Contract";
		jobCategory = "Technicians";
		joinedDate = "2020-12-01";
		subUnit = "  Quality Assurance";
		location = "New York Sales Office";
		startDate = "2021-02-01";
		endDate = "2022-02-01";

		nameSupervisor = "Jasmine Morgan";
		reportingMethod = "Direct";

		log.info("Pre-condition: Step 1 - Enter to Username textbox");
		loginPage.enterToUsernameTextbox("Admin");

		log.info("Pre-condition: Step 2 - Enter to Password textbox");
		loginPage.enterToPasswordTextbox("admin123");

		log.info("Pre-condition: Step 3 - Click on Login button");
		dashboardPage = loginPage.clickOnLoginButton();

		verifyTrue(dashboardPage.isLogoAtDashboardPageDisplayed());
	}

	@Test
	public void Employee_01_Add_Employee() {
		log.info("Add Employee: Step 1 - Open menu page by name");
		dashboardPage.openMenuPageByName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Add Employee: Step 2 - Click on Add button at Employee list page");
		employeeDetailsPage = employeeListPage.clickOnAddButtonAtEmployeeListPage();

		log.info("Add Employee: Step 3 - Enter to firstname textbox = '" + firstName + "'");
		employeeDetailsPage.enterToFirstNameTextboxAtAddEmployeeForm(firstName);

		log.info("Add Employee: Step 4 - Enter to lastname textbox = '" + lastName + "'");
		employeeDetailsPage.enterToLastNameTextboxAtAddEmployeeForm(lastName);

		employeeID = employeeDetailsPage.getEmployeeIDAtAddEmployeeForm();
		log.info("Add Employee: Step 5 - Get employeeID: '" + employeeID + "'");

		log.info("Add Employee: Step 6 - Click on Save button at Add Employee form");
		employeeDetailsPage.clickOnButtonByNameAtHeaderForm(driver, "Add Employee", "Save");

		log.info("Add Employee: Step 7 - Verify Fullname is displayed at header " + firstName + " " + lastName);
		verifyTrue(employeeDetailsPage.isFullNameDisplayedAtHeader(firstName + " " + lastName));

		log.info("Add Employee: Step 8 - Verify Firstname actual result '" + employeeDetailsPage.getFirstNameValueAtPersonalDetailsForm() + "' is equal to expected result '" + firstName + "'");
		verifyEquals(employeeDetailsPage.getFirstNameValueAtPersonalDetailsForm(), firstName);

		log.info("Add Employee: Step 9 - Verify Lastname actual result '" + employeeDetailsPage.getLastNameValueAtPersonalDetailsForm() + "' is equal to expected result '" + lastName + "'");
		verifyEquals(employeeDetailsPage.getLastNameValueAtPersonalDetailsForm(), lastName);

		log.info("Add Employee: Step 10 - Verify EmployeeID actual result '" + employeeDetailsPage.getEmployeeValueAtPersonalDetailsForm() + "' is equal to expected result '" + employeeID + "'");
		verifyEquals(employeeDetailsPage.getEmployeeValueAtPersonalDetailsForm(), employeeID);
	}

	@Test
	public void Employee_02_Edit_Employee_Personal_Details() {
		log.info("Edit Employee [Personal Details]: Step 1 - Click on Edit button at 'Personal Details' form");
		employeeDetailsPage.clickOnButtonByNameAtHeaderForm(driver, "Personal Details", "Edit");

		log.info("Edit Employee [Personal Details]: Step 2 - Enter to 'First Name' textbox with value '" + editFirstName + "'");
		employeeDetailsPage.enterToFirstNameTextboxAtPersonalDetailsForm(editFirstName);

		log.info("Edit Employee [Personal Details]: Step 3 - Enter to 'Last Name' textbox with value '" + editLastName + "'");
		employeeDetailsPage.enterToLastNameTextboxAtPersonalDetailsForm(editLastName);

		log.info("Edit Employee [Personal Details]: Step 4 - Enter to 'SSN Number' textbox with value '" + editSSNNumber + "'");
		employeeDetailsPage.enterToSSNNumberTextboxAtPersonalDetailsForm(editSSNNumber);

		log.info("Edit Employee [Personal Details]: Step 5 - Select 'Gender' radio with value '" + editGender + "'");
		employeeDetailsPage.selectGenderRadioAtPersonalDetailsForm(editGender);

		log.info("Edit Employee [Personal Details]: Step 6 - Select 'Marital Status' dropdown with value '" + editMaritalStatus + "'");
		employeeDetailsPage.selectMaritalStatusDropdownAtPersonalDetailsForm(editMaritalStatus);

		log.info("Edit Employee [Personal Details]: Step 7 - Select 'Nationality' dropdown with value '" + editNationality + "'");
		employeeDetailsPage.selectNationalityDropdownAtPersonalDetailsForm(editNationality);

		log.info("Edit Employee [Personal Details]: Step 8 - Enter to 'Date of Birth' textbox with value '" + editDOB + "'");
		employeeDetailsPage.enterToDOBTextboxAtPersonalDetailsForm(editDOB);

		log.info("Edit Employee [Personal Details]: Step 9 - Click on Save button");
		employeeDetailsPage.clickOnButtonByNameAtHeaderForm(driver, "Personal Details", "Save");

		log.info("Edit Employee [Personal Details]: Step 10 - Verify message saved successfully displayed: 'Successfully Saved'");
		verifyEquals(employeeDetailsPage.isSavedSuccessfullyDisplayed(), "Successfully Saved");

		log.info("Edit Employee [Personal Details]: Step 11 - Verify edited 'First Name' actual result '" + employeeDetailsPage.getFirstNameValueAtPersonalDetailsForm() + "' is equal to expected result '" + editFirstName + "'");
		verifyEquals(employeeDetailsPage.getFirstNameValueAtPersonalDetailsForm(), editFirstName);

		log.info("Edit Employee [Personal Details]: Step 12 - Verify edited 'Last Name' actual result '" + employeeDetailsPage.getLastNameValueAtPersonalDetailsForm() + "' is equal to expected result '" + editLastName + "'");
		verifyEquals(employeeDetailsPage.getLastNameValueAtPersonalDetailsForm(), editLastName);

		log.info("Edit Employee [Personal Details]: Step 13 - Verify edited 'SSN Number' actual result '" + employeeDetailsPage.getSSNNumberValueAtPersonalDetailsForm() + "' is equal to expected result '" + editSSNNumber + "'");
		verifyEquals(employeeDetailsPage.getSSNNumberValueAtPersonalDetailsForm(), editSSNNumber);

		log.info("Edit Employee [Personal Details]: Step 14 - Verify 'Gender' radio button is selected with value: '" + editGender + "'");
		verifyTrue(employeeDetailsPage.isGenderRadioButtonSelected(editGender));

		log.info(
				"Edit Employee [Personal Details]: Step 15 - Verify selected 'Marital Status' dropdown actual result '" + employeeDetailsPage.getMaritalStatusValueAtPersonalDetailsForm() + "' is equal to expected result '" + editMaritalStatus + "'");
		verifyEquals(employeeDetailsPage.getMaritalStatusValueAtPersonalDetailsForm(), editMaritalStatus);

		log.info("Edit Employee [Personal Details]: Step 16 - Verify selected 'Nationality' dropdown actual result '" + employeeDetailsPage.getNationalityValueAtPersonalDetailsForm() + "' is equal to expected result '" + editNationality + "'");
		verifyEquals(employeeDetailsPage.getNationalityValueAtPersonalDetailsForm(), editNationality);

		log.info("Edit Employee [Personal Details]: Step 17 - Verify edited 'Date of Birth' textbox actual result '" + employeeDetailsPage.getDOBValueAtPersonalDetailsForm() + "' is equal to expected result '" + editDOB + "'");
		verifyEquals(employeeDetailsPage.getDOBValueAtPersonalDetailsForm(), editDOB);
	}

	@Test
	public void Employee_03_Edit_Employee_By_Add_Job() {
		log.info("Edit Employee [Job]: Step 1 - Click on 'Job' tab");
		employeeDetailsPage.openSidebarTabByName(driver, "Job");

		log.info("Edit Employee [Job]: Step 2 - Click on Edit button at 'Job' form");
		employeeDetailsPage.clickOnButtonByNameAtHeaderForm(driver, "Job", "Edit");

		log.info("Edit Employee [Job]: Step 3 - Select 'Job Title' dropdown with value '" + jobTitle + "' at 'Job' form");
		employeeDetailsPage.selectJobTitleDropdownAtPersonalDetailsForm(jobTitle);

		log.info("Edit Employee [Job]: Step 4 - Select 'Employment Status' dropdown with value '" + employmentStatus + "' at 'Job' form");
		employeeDetailsPage.selectEmploymentStatusDropdownAtPersonalDetailsForm(employmentStatus);

		log.info("Edit Employee [Job]: Step 5 - Select 'Job Category' dropdown with value '" + jobCategory + "' at 'Job' form");
		employeeDetailsPage.selectJobCategoryDropdownAtPersonalDetailsForm(jobCategory);

		log.info("Edit Employee [Job]: Step 6 - Enter to 'Joined Date' textbox with value '" + joinedDate + "' at 'Job' form");
		employeeDetailsPage.enterToJoinedDateTextboxAtPersonalDetailsForm(joinedDate);

		log.info("Edit Employee [Job]: Step 7 - Select 'Sub Unit' dropdown with value '" + subUnit + "' at 'Job' form");
		employeeDetailsPage.selectSubUnitDropdownAtPersonalDetailsForm(subUnit);

		log.info("Edit Employee [Job]: Step 8 - Select 'Location' dropdown with value '" + location + "' at 'Job' form");
		employeeDetailsPage.selectLocationDropdownAtPersonalDetailsForm(location);

		log.info("Edit Employee [Job]: Step 9 - Enter to 'Start Date' textbox with value '" + startDate + "' at 'Job' form");
		employeeDetailsPage.enterToStartDateTextboxAtPersonalDetailsForm(startDate);

		log.info("Edit Employee [Job]: Step 10 - Enter to 'End Date' textbox with value '" + endDate + "' at 'Job' form");
		employeeDetailsPage.enterToEndDateTextboxAtPersonalDetailsForm(endDate);

		log.info("Edit Employee [Job]: Step 11 - Click on Save button at 'Job' form");
		employeeDetailsPage.clickOnButtonByNameAtHeaderForm(driver, "Job", "Save");

		log.info("Edit Employee [Job]: Step 12 - Verify selected 'Job Title' dropdown actual result '" + employeeDetailsPage.getJobTitleValueAtPersonalDetailsForm() + "' is equal to expected result '" + jobTitle + "'");
		verifyEquals(employeeDetailsPage.getJobTitleValueAtPersonalDetailsForm(), jobTitle.trim());

		log.info("Edit Employee [Job]: Step 13 - Verify selected 'Employment Status' dropdown actual result '" + employeeDetailsPage.getEmploymentStatusValueAtPersonalDetailsForm() + "' is equal to expected result '" + employmentStatus + "'");
		verifyEquals(employeeDetailsPage.getEmploymentStatusValueAtPersonalDetailsForm(), employmentStatus);

		log.info("Edit Employee [Job]: Step 14 - Verify selected 'Job Category' dropdown actual result '" + employeeDetailsPage.getJobCategoryValueAtPersonalDetailsForm() + "' is equal to expected result '" + jobCategory + "'");
		verifyEquals(employeeDetailsPage.getJobCategoryValueAtPersonalDetailsForm(), jobCategory);

		log.info("Edit Employee [Job]: Step 15 - Verify edited 'Joined Date' textbox actual result '" + employeeDetailsPage.getJoinedDateValueAtPersonalDetailsForm() + "' is equal to expected result '" + joinedDate + "'");
		verifyEquals(employeeDetailsPage.getJoinedDateValueAtPersonalDetailsForm(), joinedDate);

		log.info("Edit Employee [Job]: Step 16 - Verify selected 'Sub Unit' dropdown actual result '" + employeeDetailsPage.getSubUnitValueAtPersonalDetailsForm() + "' is equal to expected result '" + subUnit + "'");
		verifyEquals(employeeDetailsPage.getSubUnitValueAtPersonalDetailsForm(), subUnit);

		log.info("Edit Employee [Job]: Step 17 - Verify selected 'Location' dropdown actual result '" + employeeDetailsPage.getLocationValueAtPersonalDetailsForm() + "' is equal to expected result '" + location + "'");
		verifyEquals(employeeDetailsPage.getLocationValueAtPersonalDetailsForm(), location);

		log.info("Edit Employee [Job]: Step 18 - Verify edited 'Start Date' textbox actual result '" + employeeDetailsPage.getStartDateValueAtPersonalDetailsForm() + "' is equal to expected result '" + startDate + "'");
		verifyEquals(employeeDetailsPage.getStartDateValueAtPersonalDetailsForm(), startDate);

		log.info("Edit Employee [Job]: Step 119 - Verify edited 'End Date' textbox actual result '" + employeeDetailsPage.getEndDateValueAtPersonalDetailsForm() + "' is equal to expected result '" + endDate + "'");
		verifyEquals(employeeDetailsPage.getEndDateValueAtPersonalDetailsForm(), endDate);
	}

	@Test
	public void Employee_04_Edit_Employee_By_Add_Salary() {
		log.info("Edit Employee [Add Salary Component]: Step 1 - Click on 'Salary' tab");
		employeeDetailsPage.openSidebarTabByName(driver, "Salary");

		log.info("Edit Employee [Add Salary Component]: Step 2 - Click on Add button at 'Assigned Salary Components' form");
		employeeDetailsPage.clickOnButtonByNameAtHeaderForm(driver, "Assigned Salary Components", "Add");

		log.info("Edit Employee [Add Salary Component]: Step 3 - Select 'Pay Grade' dropdown with value '" + payGrade + "' at 'Assigned Salary Components' form");
		employeeDetailsPage.selectPayGradeDropdownAtAddSalaryForm(payGrade);

		log.info("Edit Employee [Add Salary Component]: Step 4 - Enter to 'Salary Component' textbox with value '" + salaryComponent + "' at 'Assigned Salary Components' form");
		employeeDetailsPage.enterToSalaryComponentTextboxAtAddSalaryForm(salaryComponent);

		log.info("Edit Employee [Add Salary Component]: Step 5 - Select 'Pay Frequency' dropdown with value '" + payFrequency + "' at 'Assigned Salary Components' form");
		employeeDetailsPage.selectPayFrequencyDropdownAtAddSalaryForm(payFrequency);

		log.info("Edit Employee [Add Salary Component]: Step 6 - Select 'Currency' dropdown with value '" + currency + "' at 'Assigned Salary Components' form");
		employeeDetailsPage.selectCurrencyDropdownAtAddSalaryForm(currency);

		log.info("Edit Employee [Add Salary Component]: Step 7 - Enter to 'Amount' textbox with value '" + currency + "' at 'Assigned Salary Components' form");
		employeeDetailsPage.enterToAmountTextboxAtAddSalaryForm(amount);

		log.info("Edit Employee [Add Salary Component]: Step 8 - Enter to 'Comment' textbox with value '" + comment + "' at 'Assigned Salary Components' form");
		employeeDetailsPage.enterToCommentTextboxAtAddSalaryForm(comment);

		log.info("Edit Employee [Add Salary Component]: Step 9 - Click on Save button at 'Assigned Salary Components' form");
		employeeDetailsPage.clickOnButtonByNameAtHeaderForm(driver, "Add Salary Component", "Save");

		log.info("Edit Employee [Personal Details]: Step 10 - Verify message saved successfully displayed: 'Successfully Saved'");
		verifyEquals(employeeDetailsPage.isSavedSuccessfullyDisplayed(), "Successfully Saved");

		log.info("Edit Employee [Personal Details]: Step 10 - Verify added salary successfully");
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Salary Component", "1", salaryComponent));
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Pay Frequency", "1", payFrequency));
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Currency", "1", currency));
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Amount", "1", amount));
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "tblSalary", "Comments", "1", comment));
	}

	@Test
	public void Employee_05_Edit_Employee_By_Report_To() {
		log.info("Edit Employee [Report To]: Step 1 - Click on 'Report-to' tab");
		employeeDetailsPage.openSidebarTabByName(driver, "Report-to");

		log.info("Edit Employee [Report To]: Step 2 - Click on Add button at 'Add Supervisor' form");
		employeeDetailsPage.clickOnButtonByNameAtHeaderForm(driver, "Assigned Supervisors", "Add");

		log.info("Edit Employee [Report To]: Step 3 - Enter to 'Name' textbox with value '" + nameSupervisor + "' at 'Add Supervisor' form");
		employeeDetailsPage.enterToNameSupervisorTextboxAtAddSupervisorForm(nameSupervisor);

		log.info("Edit Employee [Report To]: Step 4 - Select 'Reporting Method' dropdown with value '" + reportingMethod + "' at 'Add Supervisor' form");
		employeeDetailsPage.selectReportingMethodDropdownAtAddSupervisorForm(reportingMethod);

		log.info("Edit Employee [Report To]: Step 5 - Click on Save button at 'Add Supervisor' form");
		employeeDetailsPage.clickOnButtonByNameAtHeaderForm(driver, "Add Supervisor", "Save");

		log.info("Edit Employee [Report To]: Step 6 - Verify added Supervisor successfully");
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "sup_list", "Name", "1", nameSupervisor));
		verifyTrue(employeeDetailsPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "sup_list", "Reporting Method", "1", reportingMethod));
	}

	@Test
	public void Employee_06_Search_Employee() {
		log.info("Search Employee: Step 1 - Open 'Employee List' page");
		employeeDetailsPage.openMenuPageByName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		/* Search with Employee Name */
		log.info("Search Employee: Step 2 - Enter to 'Employee Name' textbox with value '" + editFirstName + " " + editLastName + "'");
		employeeListPage.sleepInSeconds(3);
		employeeListPage.enterToEmployeeNameTextboxAtEmployeeInformationForm(editFirstName + " " + editLastName);

		log.info("Search Employee: Step 3 - Click on Search button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Search");
		employeeListPage.sleepInSeconds(2);

		log.info("Search Employee: Step 4 - Verify search by Employee Name");
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", nameSupervisor));

		log.info("Search Employee: Step 5 - Click on Reset button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSeconds(2);

		/* Search with Employee ID */
		log.info("Search Employee: Step 6 - Enter to 'Employee ID' textbox with value '" + employeeID + "'");
		employeeListPage.enterToEmployeeIDTextboxAtEmployeeInformationForm(employeeID);

		log.info("Search Employee: Step 7 - Click on Search button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Search");
		employeeListPage.sleepInSeconds(2);

		log.info("Search Employee: Step 8 - Verify search by Employee Name");
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", nameSupervisor));

		log.info("Search Employee: Step 9 - Click on Reset button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSeconds(2);

		/* Search with Employee Name and Employment Status */
		log.info("Search Employee: Step 10 - Enter to 'Employee Name' textbox with value '" + editFirstName + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextboxAtEmployeeInformationForm(editFirstName + " " + editLastName);

		log.info("Search Employee: Step 11 - Select 'Employment Status' dropdown with value '" + employmentStatus + "'");
		employeeListPage.selectEmploymentStatusAtEmployeeInformationForm(employmentStatus);

		log.info("Search Employee: Step 12 - Click on Search button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Search");
		employeeListPage.sleepInSeconds(2);

		log.info("Search Employee: Step 13 - Verify search by Employee Name");
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", nameSupervisor));

		log.info("Search Employee: Step 14 - Click on Reset button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSeconds(2);

		/* Search with Employee Name and Include 'Current Employees Only' */
		log.info("Search Employee: Step 15 - Enter to 'Employee Name' textbox with value '" + editFirstName + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextboxAtEmployeeInformationForm(editFirstName + " " + editLastName);

		log.info("Search Employee: Step 16 - Select 'Include' dropdown with value 'Current Employees Only'");
		employeeListPage.selectIncludeAtEmployeeInformationForm("Current Employees Only");

		log.info("Search Employee: Step 17 - Click on Search button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Search");
		employeeListPage.sleepInSeconds(2);

		log.info("Search Employee: Step 18 - Verify search by Employee Name");
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", nameSupervisor));

		log.info("Search Employee: Step 19 - Click on Reset button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSeconds(2);

		/* Search with Employee Name and Include 'Current and Past Employees' */
		log.info("Search Employee: Step 20 - Enter to 'Employee Name' textbox with value '" + editFirstName + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextboxAtEmployeeInformationForm(editFirstName + " " + editLastName);

		log.info("Search Employee: Step 21 - Select 'Include' dropdown with value 'Current and Past Employees'");
		employeeListPage.selectIncludeAtEmployeeInformationForm("Current and Past Employees");

		log.info("Search Employee: Step 22 - Click on Search button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Search");
		employeeListPage.sleepInSeconds(2);

		log.info("Search Employee: Step 23 - Verify search by Employee Name");
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", nameSupervisor));

		log.info("Search Employee: Step 24 - Click on Reset button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSeconds(2);

		/* Search with Employee Name and Include 'Past Employees Only' */
		log.info("Search Employee: Step 25 - Enter to 'Employee Name' textbox with value '" + editFirstName + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextboxAtEmployeeInformationForm(editFirstName + " " + editLastName);

		log.info("Search Employee: Step 26 - Select 'Include' dropdown with value 'Past Employees Only'");
		employeeListPage.selectIncludeAtEmployeeInformationForm("Past Employees Only");

		log.info("Search Employee: Step 27 - Click on Search button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Search");
		employeeListPage.sleepInSeconds(2);

		log.info("Search Employee: Step 28 - Verify search by Employee Name");
		verifyTrue(employeeListPage.isNoRecordFoundByTableID(driver, "resultTable"));
		
		log.info("Search Employee: Step 29 - Click on Reset button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSeconds(2);
		
		/* Search with Employee ID and Supervisor Name */
		log.info("Search Employee: Step 30 - Enter to 'Employee ID' textbox with value '" + employeeID + "'");
		employeeListPage.enterToEmployeeIDTextboxAtEmployeeInformationForm(employeeID);
	
		log.info("Search Employee: Step 31 - Enter to 'Supervisor Name' textbox with value '" + nameSupervisor + "'");
		employeeListPage.enterToSupervisorNameTextboxAtEmployeeInformationForm(nameSupervisor);

		log.info("Search Employee: Step 32 - Click on Search button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Search");
		employeeListPage.sleepInSeconds(2);

		log.info("Search Employee: Step 33 - Verify search by Employee Name");
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", nameSupervisor));

		log.info("Search Employee: Step 34 - Click on Reset button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSeconds(2);
		
		/* Search with Employee Name and Job Title */
		log.info("Search Employee: Step 35 - Enter to 'Employee Name' textbox with value '" + editFirstName + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextboxAtEmployeeInformationForm(editFirstName + " " + editLastName);

		log.info("Search Employee: Step 35 - Select 'Job Title' dropdown with value '" + jobTitle + "'");
		employeeListPage.selectJobTitleAtEmployeeInformationForm(jobTitle);

		log.info("Search Employee: Step 37 - Click on Search button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Search");
		employeeListPage.sleepInSeconds(2);

		log.info("Search Employee: Step 38 - Verify search by Employee Name");
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", nameSupervisor));

		log.info("Search Employee: Step 39 - Click on Reset button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Reset");
		employeeListPage.sleepInSeconds(2);
		
		/* Search with Employee ID and Sub Unit */
		log.info("Search Employee: Step 40 - Enter to 'Employee Name' textbox with value '" + editFirstName + " " + editLastName + "'");
		employeeListPage.enterToEmployeeNameTextboxAtEmployeeInformationForm(editFirstName + " " + editLastName);

		log.info("Search Employee: Step 41 - Select 'Sub Unit' dropdown with value '" + subUnit + "'");
		employeeListPage.selectSubUnitAtEmployeeInformationForm(subUnit);

		log.info("Search Employee: Step 42 - Click on Search button at 'Employee Information' form");
		employeeListPage.clickOnButtonByNameAtHeaderForm(driver, "Employee Information", "Search");
		employeeListPage.sleepInSeconds(2);

		log.info("Search Employee: Step 43 - Verify search by Employee Name");
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Id", "1", employeeID));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "First (& Middle) Name", "1", editFirstName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Last Name", "1", editLastName));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Job Title", "1", jobTitle));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Employment Status", "1", employmentStatus));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Sub Unit", "1", subUnit.trim()));
		verifyTrue(employeeListPage.isInformationDisplayedAtColumnNameAndRowNumber(driver, "resultTable", "Supervisor", "1", nameSupervisor));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
