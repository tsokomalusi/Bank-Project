package test;


/*
 * class for parameters needed for the script
 * and are changeable to suite the environment (code maintainance)
 */

public class Util {
	
	/*
	 * 
	 * path of the firefox, firefox and geckodriver 
	   based on the environment can be changed here
	  
	 */
	
	public static final String DRIVER_PATH = "C:\\Drivers\\geckodriver.exe";

	public static final String BIN_PATH = "C:\\Program Files\\Mozilla Firefox\\firefox";
	
	public static final String FIREFOX_PROFILE_PATH = "C:\\Users\\Asus\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles";
	
	//setting the Base URL
	public static final String BASE_URL = "https://www.demo.guru99.com/V4/";
	
	//Time to wait when searching for a GUI element
	public static final int WAIT_TIME = 30;
	
	//Valid account for login
	public static final String USERNAME= "mngr476324";
	public static final String PASSWORD = "supYsYb";
	
	//Expected output/title
	
	public static final String EXPECTED_TITLE = "Guru99 Bank Manager HomePage";
	
	
}
