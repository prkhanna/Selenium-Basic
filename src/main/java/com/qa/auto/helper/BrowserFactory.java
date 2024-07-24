package com.qa.auto.helper;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
private WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void setDriver()
	{
		 WebDriverManager.chromedriver().setup();
	        
	        // Initialize ChromeDriver
	         driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");

	//	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
}
