package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLogin_DataProvider_Example_For_error_messages extends OrangeHRMTestData {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	/*
	 * @Test(priority = 1, dataProvider = "loginValidation") public void
	 * Login(String username, String password, String expectedMessage) throws
	 * Exception { Thread.sleep(15000);
	 * 
	 * driver.findElement(By.xpath("//input[@name='txtUsername']")).clear();
	 * driver.findElement(By.cssSelector("input[name='txtPassword']")).clear(); //
	 * Launch the browser
	 * driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(
	 * username);
	 * driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys(
	 * password); driver.findElement(By.id("btnLogin")).click(); Thread.sleep(2000);
	 * 
	 * try { boolean flag =
	 * driver.findElementById("logInPanelHeading").isDisplayed();
	 * 
	 * if (flag) { if (username == "" && password == "") {
	 * assertEquals(expectedMessage,
	 * driver.findElementByXPath("//span[@id='spanMessage']").getText()); } else if
	 * (username != "" && password == "") { assertEquals(expectedMessage,
	 * driver.findElementByXPath("//span[@id='spanMessage']").getText()); } else if
	 * (username == "" && password != "") { assertEquals(expectedMessage,
	 * driver.findElementByXPath("//span[@id='spanMessage']").getText()); } } else
	 * if (driver.findElement(By.linkText("Dashboard")).isDisplayed()) {
	 * assertTrue(driver.findElement(By.linkText(expectedMessage)).isDisplayed()); }
	 * else { throw new Exception("Wrong data"); } } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	@Test(dataProvider = "LoginExcelData")
	public void Sign_On(String uname, String password) throws InterruptedException

	{
		Thread.sleep(10000);

		driver.findElement(By.name("txtUsername")).sendKeys(uname);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		// ----------------To Verify Logout Function without using
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("logInPanelHeading")).isDisplayed();
	}

}
