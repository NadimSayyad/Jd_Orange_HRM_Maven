package com.SingleExtentReport_Example;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLogin_TestNG {
	ChromeDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(15000);
		// Launch the browser
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.findElement(By.linkText("My Info")).isDisplayed();
		// driver.close(); //Close the current browser
		
	}
	
	@Test(priority = 2)
	public void Logout() throws InterruptedException {
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		String actualText = driver.findElement(By.id("logInPanelHeading")).getText();
		String url = driver.getCurrentUrl();
		String actualTite = driver.getTitle();
		assertEquals(url, "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		assertEquals(actualText, "LOGIN Panel");
		assertEquals(actualTite, "OrangeHRM");
	}

}
