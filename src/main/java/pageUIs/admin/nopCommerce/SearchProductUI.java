package pageUIs.admin.nopCommerce;

public class SearchProductUI {
	public static final String SEARCH_PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String EDIT_BUTTON_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td//a[text()='Edit']";
	public static final String SUCCESS_MESSAGE_UPDATED = "//div[contains(@class,'alert-success') and contains(string(),'%s')]";
	public static final String IMAGE_UPLOADED_SUCCESS_BY_PICTURE_AND_PRODUCT_NAME = "//img[contains(@src,'%s')]/parent::td/following-sibling::td[text()='%s']";

}
