package com.OrangeHRM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrageHRM_AddUser_DropDown_Exaple {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
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
		WebDriverWait driverWait = new WebDriverWait(driver, 20);
		WebElement element = driverWait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='txtUsername']")));
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.findElement(By.linkText("My Info")).isDisplayed();
		// driver.close(); //Close the current browser

	}

	@Test(priority = 2)
	public void moiveHoveronAdmin() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(15000);
		// Launch the browser

		WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

		Actions action = new Actions(driver);

		action.moveToElement(admin).build().perform();
		WebElement usermanagement = driver.findElementByLinkText("User Management");
		action.moveToElement(usermanagement).build().perform();
		// driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("//input[@name='txtUsername']")));
		driver.findElementByLinkText("Users").click();
		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");

	}

	@Test(priority = 3)
	public void addUser() throws InterruptedException {
		driver.findElementById("btnAdd").click();
		Select userRole = new Select(driver.findElementById("systemUser_userType"));
		Select userStatus = new Select(driver.findElementByName("systemUser[status]"));
		//userRole.selectByVisibleText("Admin");
		//userRole.selectByValue("1");
		userRole.selectByIndex(0);
		userStatus.selectByIndex(0);
		
		driver.findElementByName("systemUser[employeeName][empName]").sendKeys("123");
		driver.findElementByName("systemUser[userName]").sendKeys("123");
		driver.findElementByName("systemUser[password]").sendKeys("123");
		driver.findElementByName("systemUser[confirmPassword]").sendKeys("123");
		driver.findElementByName("btnSave").click();
		Thread.sleep(2000);

	}

	@Test(priority = 4)
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
