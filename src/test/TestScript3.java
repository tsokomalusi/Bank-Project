package test;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class TestScript3 {

	static WebDriver driver;
	private static String baseUrl;

	public static void setUp()   {

		/*Tells the Selenium client library to connect to the Webdriver
		 * service using firefox*/

		FirefoxOptions options = new FirefoxOptions();

		driver = new FirefoxDriver(options);

		baseUrl = Util.BASE_URL;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.WAIT_TIME));

		driver.get(baseUrl);

	}

	public static void main(String[] args) throws IOException {

		String[][] testData = Util.getXLData(Util.SHEET_NAME);

		String username, password;
		String actualTitle;
		String actualBoxtitle;

		for (int i = 0; i <= testData.length; i++) {
			username = testData[i][0]; // get username
			password = testData[i][1]; // get password

			//Setup Firefox driver
			setUp();
			// Enter username
			driver.findElement(By.name("uid")).clear();
			driver.findElement(By.name("uid")).sendKeys(username);

			// Enter Password
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);

			// Click Login
			driver.findElement(By.name("btnLogin")).click();

			/* Determine Pass Fail Status of the Script
			 * If login credentials are correct,  Alert(Pop up) is NOT present. An Exception is thrown and code in catch block is executed	
			 * If login credentials are invalid, Alert is present. Code in try block is executed 	    
			 */
			
		
		    try{ 
		    
		       	Alert alt = driver.switchTo().alert();
				actualBoxtitle = alt.getText(); // get content of the Alter Message
				alt.accept();
				
				// Compare Error Text with Expected Error Value
				
				if (actualBoxtitle.contains(Util.EXPECT_ERROR)) { 
					
				    System.out.println("Test case SS[" + i + "]: Failed"); 
				} else {
				    System.out.println("Test case SS[" + i + "]: Passed");
				}
			}    
		    catch (NoAlertPresentException Ex){ 
		    	actualTitle = driver.getTitle();
		    	
				// On Successful login compare Actual Page Title with Expected Title
		    	
				if (actualTitle.contains(Util.EXPECT_TITLE)) {
				    System.out.println("Test case SS[" + i + "]: Passed");
				} else {
				    System.out.println("Test case SS[" + i + "]: Failed");
				}
				
	        } 
			driver.quit();
		} 


	}
}
