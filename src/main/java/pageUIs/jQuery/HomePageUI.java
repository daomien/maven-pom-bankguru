package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGINATION_BY_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGINATION_ACTIVATED_BY_NUMBER = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	
	public static final String TEXTBOX_HEADER_TABLE = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String ICON_BY_COUNTRY_NAME = "//td[@data-key='country' and text()='%s']/preceding::td//button[@class='qgrd-%s-row-btn']";
	public static final String ROW_VALUE = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String HEADER_NAME = "//th[text()='%s']/preceding::th";
	public static final String TEXTBOX_ROW_BY_COLUMN_ROW_INDEX = "//tr[%s]//td[%s]/input";
	public static final String ICON_BY_ROW_NUMBER = "//tr[@id][%s]//td//button[@title='%s']";

}
