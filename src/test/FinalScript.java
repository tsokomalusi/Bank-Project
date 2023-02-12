package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;

public class FinalScript {

	public WebDriver driver;
	public String baseUrl;

	//data set of username and password for testing

	@DataProvider(name = "credentials")
	public Object[][] testData()  {

		return new Object[][] {

			{"bothvalid", Util.USER_NAME, Util.PASSWD},
			{"validpassword", "mngr0020223", Util.PASSWD},
			{"validusername", Util.USER_NAME, "supXsXb"},
			{"bothinvalid", "mngr002022", "supXsXb"}

		};
	}

	@Test(dataProvider = "credentials" )
	public void testCase05(String scenario, String username, 
			String password) throws Exception {

		String actualBoxMsg;

		//Enter username
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);

		//Enter password
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);

		// Click Login
		driver.findElement(By.name("btnLogin")).click();

		if(scenario.equals("bothvalid"))  {

			// Get text displayes on login page

			String path = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]";
			String text = driver.findElement
					(By.xpath(path)).getText();

			System.out.println(text);

			// Extract the dynamic text mngrXXXX on page		
			String[] parts = text.split(Util.PATTERN);
			String dynamicText = parts[1];

			// Check that the dynamic text is of pattern mngrXXXX
			// First 4 characters must be "mngr"
			assertTrue(dynamicText.substring(1, 5).equals(Util.FIRST_PATTERN));

			// remain stores the "XXXX" in pattern mngrXXXX
			String remain = dynamicText.substring(dynamicText.length() - 4);

			// Check remain string must be numbers;
			assertTrue(remain.matches(Util.SECOND_PATTERN));

			//code for taking screenshot
			TakesScreenshot ts = (TakesScreenshot)driver;

			//capture screenshot as output type FILE
			File file = ts.getScreenshotAs(OutputType.FILE);

			try {
				//save the screenshot taken in destination path
				FileUtils.copyFile(file, new File("./resources/screenshots/validLoginop.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("the login page screenshot is taken");


		}

		else {

			Alert alt = driver.switchTo().alert();
			actualBoxMsg = alt.getText(); // get content of the Alter Message
			alt.accept();
			// Compare Error Text with Expected Error Value					
			assertEquals(actualBoxMsg,Util.EXPECT_ERROR);
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
	public void afterTest() throws Exception {

		driver.quit();
	}

}
