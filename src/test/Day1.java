package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day1 {


	public static void main(String[] args) {

		WebDriver driver;

		//AUT
		String baseURL = "https://www.demo.guru99.com/V4/";

		System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin",  "C:\\Program Files\\Mozilla Firefox\\firefox");

		//Instantiating the driver
		driver = new FirefoxDriver();

		//Launching browser session
		driver.get(baseURL);

		//Locating GUI elements
		driver.findElement(By.name("uid")).sendKeys("mngr476324");
		driver.findElement(By.name("password")).sendKeys("supYsYb");
		driver.findElement(By.name("btnLogin")).click();

		//Terminating browser session
		driver.quit();
	}

}




