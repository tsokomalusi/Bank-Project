package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day1 {
	
	
public static void main(String[] args)  {
		
		WebDriver driver;
		String baseURL = "http://www.demo.guru99.com/V4/";
		
		driver = new FirefoxDriver();
		
		driver.get(baseURL);
		
		driver.findElement(By.name("uid")).sendKeys("mngr471494");
		driver.findElement(By.name("password")).sendKeys("yzuqAma");
		driver.findElement(By.name("btnLogin")).click();
		
		driver.quit();
		
		
		
	}

}




