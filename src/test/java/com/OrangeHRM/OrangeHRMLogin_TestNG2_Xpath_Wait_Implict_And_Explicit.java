package com.OrangeHRM;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLogin_TestNG2_Xpath_Wait_Implict_And_Explicit {
	ChromeDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.manage().window().maximize();
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
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Welcome")));
		String ActText=element.getText();
		System.out.println(ActText);
		element.click();
	}

}
