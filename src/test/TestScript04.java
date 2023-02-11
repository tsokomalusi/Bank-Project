package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;

public class TestScript04 {
	
	private static WebDriver driver; 
	private static String baseUrl; 
	
	@DataProvider(name = "Guru99Test")
	public Object[][] testData() throws Exception {
		return Util.getXLData(Util.SHEET_NAME);
	}


	@Test(dataProvider = "Guru99Test")
	public void testCase04(String username, String password) throws Exception {
		
		String actualTitle;
		String actualBoxMsg;
		
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		//Set a delay in case the internet is slow
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.WAIT_TIME));
		
		   try{ 
			    
		       	Alert alt = driver.switchTo().alert();
		     // get content of the Alter Message
				actualBoxMsg = alt.getText(); 
				alt.accept();
				 // Compare Error Text with Expected Error Value					
				assertEquals(actualBoxMsg,Util.EXPECT_ERROR);
				
			}    
		    catch (NoAlertPresentException Ex){ 
		    	
		    	actualTitle = driver.getTitle();
		    	
				// On Successful login compare Actual Page Title with Expected Title
		    	assertEquals(actualTitle,Util.EXPECT_TITLE);
	        } 
		}
	
  @BeforeTest
  public void setUp() throws Exception  {

		FirefoxOptions options = new FirefoxOptions();

		driver = new FirefoxDriver(options);

		baseUrl = Util.BASE_URL;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.WAIT_TIME));

		driver.get(baseUrl);

	}

  @AfterTest
  public void tearDown() throws Exception {
	  
	  driver.quit();
  }

}
