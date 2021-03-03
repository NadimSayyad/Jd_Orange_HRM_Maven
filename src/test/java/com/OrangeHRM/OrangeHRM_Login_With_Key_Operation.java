package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_With_Key_Operation {

	WebDriver driver;

	@Test
	public void Login() throws InterruptedException {
		Thread.sleep(13000);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin", Keys.TAB, "admin123", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.findElement(By.linkText("My Info")).isDisplayed();

	}

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

	@AfterTest
	public void CloseBrowser() {
		// driver.close();//Close will close only current chrome browser
		driver.quit();
	}
}