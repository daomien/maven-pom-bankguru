package pageUIs.admin.nopCommerce;

public class EditProductDetailsUI {
	public static final String PICTURE_UPLOADED_BY_FILE_NAME = "//div[@class='uploaded-image']//img[contains(@src,'%s')]";
	public static final String ALT_PICTURE_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_PICTURE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAY_ORDER_DROPDOWN = "//input[@id='AddPictureModel_DisplayOrder']/following-sibling::span/span[@title='Increase value']";
	public static final String ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";
	public static final String TABLE_PRODUCT_PICTURE_ADDED = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";
	public static final String SAVE_BUTTON = "//button[@name='save']";
	public static final String EXPAND_BUTTON_BY_SECTION_NAME = "//div[@class='card-title' and text()='%s']/following-sibling::div//i[contains(@class,'fa-minus')]";
	public static final String DELETE_BUTTON_BY_TITLE_PICTURE = "//td[@data-columnname='OverrideTitleAttribute' and text()='%s']/following-sibling::td//a[text()='Delete']";
	public static final String SECTION_NAME = "//div[@class='card-title' and text()='%s']";

}
