package com.log4j;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Log_Example;

public class Orange_HRM_Prox_Log4j_example {
	
	WebDriver driver;

	@BeforeTest
	public void LaunchBrowser() {
		ChromeOptions chromeOptions = new ChromeOptions();
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("localhost:8080");
		chromeOptions.setProxy(proxy);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@Test
	public void OrangeHRM_Login() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(By.name("txtUsername")).clear();
			driver.findElement(By.name("txtUsername")).sendKeys("admin");
			Log_Example.info("clean test boxes");
			driver.findElement(By.name("txtPassword")).clear();
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			Log_Example.debug("User Clicked on Logout button");

	}
	

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
		Log_Example.endLog("chrome browser closed");
	}

}
