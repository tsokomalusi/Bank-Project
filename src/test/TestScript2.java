package test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class TestScript2  {

	//selenium control driver
	static WebDriver driver;

	//URL of the AUT
	public static String baseURL;

	//method to read initializtion parameters from Util class and launch firefox browser
	public static void setUp()  {

		/*Tells the Selenium client library to connect to the Webdriver
		 * service using firefox*/

		FirefoxOptions options = new FirefoxOptions();
		

		//creating a profile
		FirefoxProfile profile = new FirefoxProfile();

		options.setProfile(profile);

		driver = new FirefoxDriver(options);

		baseURL = Util.BASE_URL;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.WAIT_TIME));

		driver.get(baseURL);
	}

	public static void main(String[] args) throws Exception {

		String actualTitle;

		//setup firefox driver
		setUp();

		//clearing username field 
		driver.findElement(By.name("uid")).clear();

		//Entering username
		driver.findElement(By.name("uid")).sendKeys(Util.USER_NAME);

		//clearing password field
		driver.findElement(By.name("password")).clear();

		//Entering password
		driver.findElement(By.name("password")).sendKeys(Util.PASSWD);

		//click login
		driver.findElement(By.name("btnLogin")).click();

		actualTitle = driver.getTitle();

		if(actualTitle.contains(Util.EXPECT_TITLE)) {

			System.out.println("Test Case: Passed!");
		}
		else {

			System.out.println("Test Case: Failed!");
		}

		driver.quit();

	}


}
