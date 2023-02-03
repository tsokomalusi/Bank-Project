package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day1 {


	public static void main(String[] args)  {

		WebDriver driver;

		//AUT
		String baseURL = "https://www.demo.guru99.com/V4/";

		//Instantiating the driver
		driver = new FirefoxDriver();

		//Launching browser session
		driver.get(baseURL);

		//Locating GUI elements
		driver.findElement(By.name("uid")).sendKeys("mngr471494");
		driver.findElement(By.name("password")).sendKeys("yzuqAma");
		driver.findElement(By.name("btnLogin")).click();

		//Terminating browser session
		driver.quit();



	}

}




