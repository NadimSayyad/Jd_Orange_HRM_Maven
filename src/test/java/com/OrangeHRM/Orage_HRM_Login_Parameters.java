package com.OrangeHRM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orage_HRM_Login_Parameters {
	WebDriver driver;

	@Test
	@Parameters({ "url", "uname", "upass" })
	public void Login(String url, String uname, String upass) throws InterruptedException {
		// driver.navigate().to(url);
		driver.get(url);
		Thread.sleep(13000);
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(uname);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(upass);
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h1[contains(text(),'Web Orders')]")).isDisplayed();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		assertEquals(title, "Web Orders Login");

	}

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void CloseBrowser() {
		// driver.close();//Close will close only current chrome browser
		driver.quit();
	}
}
