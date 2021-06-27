package commons;

import java.io.File;

public class GlobalConstants {

	public static final int SHORT_TIMEOUT = 10;
	public static final int LONG_TIMEOUT = 30;
	public static final String PROJECT_LOCATION_PATH = System.getProperty("user.dir");

	public static final String UPLOAD_IMAGE_FOLDER_PATH = PROJECT_LOCATION_PATH + "/src/main/resources/" + "uploadFiles" + File.separator;
}
