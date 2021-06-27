package pageUIs.admin.nopCommerce;

public class AdminBasePageUI {
	public static final String MENU_LINK_BY_NAME = "//a[@href='#']//p[normalize-space(text())='%s']";
	public static final String SUBMENU_LINK_BY_NAME = "//ul[@style]//p[normalize-space(text())='%s']";
	public static final String UPLOAD_FILE_BUTTON_BY_CARD_NAME = "//div[@data-card-name='%s']//input[@type='file']";
	public static final String EMPTY_MESSAGE_IN_TABLE_BY_CARD_NAME = "//div[@id='%s']//td[text()='No data available in table']";

}
