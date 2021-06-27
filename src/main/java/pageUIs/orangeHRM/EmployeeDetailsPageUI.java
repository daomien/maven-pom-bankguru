package pageUIs.orangeHRM;

public class EmployeeDetailsPageUI {
	// Add Employee form
	public static final String FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='firstName']";
	public static final String LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='lastName']";
	public static final String EMPLOYEEID_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='employeeId']";

	// Personal Details form
	public static final String FULLNAME_TEXT_AT_PERSONAL_DETAILS_FORM = "//div[@id='profile-pic']/h1[text()='%s']";
	public static final String FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM = "//input[@id='personal_txtEmpFirstName']";
	public static final String LASTNAME_TEXTBOX_AT_PERSONAL_DETAILS_FORM = "//input[@id='personal_txtEmpLastName']";
	public static final String EMPLOYEEID_TEXT_AT_PERSONAL_DETAILS_FORM = "//input[@id='personal_txtEmployeeId']";
	public static final String SSNNUMBER_TEXTBOX_AT_PERSONAL_DETAILS_FORM = "//input[@id='personal_txtNICNo']";
	public static final String GENDER_RADIO_BUTTON_AT_PERSONAL_DETAILS_FORM = "//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAILS_FORM = "//select[@id='personal_cmbMarital']";
	public static final String NATIONALITY_DROPDOWN_AT_PERSONAL_DETAILS_FORM = "//select[@id='personal_cmbNation']";
	public static final String DOB_TEXTBOX_AT_PERSONAL_DETAILS_FORM = "//input[@id='personal_DOB']";
	public static final String SUCCESS_MESSAGE_TEXT = "//div[contains(@class,'message success')]";

	// Add Salary Component
	public static final String PAY_GRADE_DROPDOWN_AT_ADD_SALARY_FORM = "//select[@id='salary_sal_grd_code']";
	public static final String SALARY_COMPONENT_TEXTBOX_AT_ADD_SALARY_FORM = "//input[@id='salary_salary_component']";
	public static final String PAY_FREQUENCY_DROPDOWN_AT_ADD_SALARY_FORM = "//select[@id='salary_payperiod_code']";
	public static final String CURRENCY_DROPDOWN_AT_ADD_SALARY_FORM = "//select[@id='salary_currency_id']";
	public static final String AMOUNT_TEXTBOX_AT_ADD_SALARY_FORM = "//input[@id='salary_basic_salary']";
	public static final String COMMENT_TEXTBOX_AT_ADD_SALARY_FORM = "//textarea[@id='salary_comments']";

	// Edit Job
	public static final String JOB_TITLE_DROPDOWN_AT_JOB_FORM = "//select[@id='job_job_title']";
	public static final String EMPLOYEMENT_STATUS_DROPDOWN_AT_JOB_FORM = "//select[@id='job_emp_status']";
	public static final String JOB_CATEGORY_DROPDOWN_AT_JOB_FORM = "//select[@id='job_eeo_category']";
	public static final String JOINED_DATE_TEXTBOX_AT_ADD_SALARY_FORM = "//input[@id='job_joined_date']";
	public static final String SUB_UNIT_DROPDOWN_AT_JOB_FORM = "//select[@id='job_sub_unit']";
	public static final String LOCATION_DROPDOWN_AT_JOB_FORM = "//select[@id='job_location']";
	public static final String START_DATE_TEXTBOX_AT_ADD_SALARY_FORM = "//input[@id='job_contract_start_date']";
	public static final String END_DATE_TEXTBOX_AT_ADD_SALARY_FORM = "//input[@id='job_contract_end_date']";

	// Add supervisor
	public static final String NAME_SUPERVISOR_TEXTBOX_AT_ADD_SALARY_FORM = "//input[@id='reportto_supervisorName_empName']";
	public static final String REPORTING_METHOD_DROPDOWN_AT_JOB_FORM = "//select[@id='reportto_reportingMethodType']";

}
