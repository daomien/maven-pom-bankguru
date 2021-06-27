package pageUIs.orangeHRM;

public class EmployeeBasePageUI {
	public static final String DYNAMIC_MENU_BY_NAME = "//a[string()='%s']";
	public static final String DYNAMIC_BUTTON_BY_NAME_AT_HEADER_FORM = "//h1[text()='%s']/parent::div/following-sibling::div//input[@value='%s']";
	public static final String DYNAMIC_SIDEBAR_BY_NAME = "//ul[@id='sidenav']//a[text()='%s']";
	public static final String DYNAMIC_TABLE_COLUMN_NAME = "//table[@id='%s']//th[string()='%s']/preceding::th";
	public static final String CELL_VALUE_BY_COLUMN_AND_ROW_INDEX = "//tr[%s]//td[%s]";
	public static final String NO_RECORD_FOUND_BY_TABLE_ID = "//table[@id='%s']//td[text()='No Records Found']";
}
