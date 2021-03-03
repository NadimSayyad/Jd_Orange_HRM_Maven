package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateExample {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//not secure -  store cache and cookie
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	
		
		//secure - not store cache and cookie
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@Test
	public void login() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.findElement(By.linkText("My Info")).isDisplayed();
		
	}

	@Test(priority = 2)
	public void navigateTesting() throws InterruptedException {
		// Add 5 seconds wait
		Thread.sleep(5000);
		// Create object of actions class
		//driver.navigate().back();
		//driver.navigate().forward();
		
	}
}
