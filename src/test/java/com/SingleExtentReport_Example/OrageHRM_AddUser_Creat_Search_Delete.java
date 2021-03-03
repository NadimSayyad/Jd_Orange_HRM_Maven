package com.SingleExtentReport_Example;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrageHRM_AddUser_Creat_Search_Delete {
	ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void Search() throws InterruptedException {

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(15000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		WebElement Admin = driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
		
		//Add User Section
		Actions action = new Actions(driver);
		action.moveToElement(Admin).build().perform();

		WebElement usermanagement = driver.findElement(By.linkText("User Management"));
		action.moveToElement(usermanagement).build().perform();

		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		Select SelectPass = new Select(driver.findElement(By.id("systemUser_userType")));
		SelectPass.selectByValue("1");
		
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		
		//Using Randon class, we can generate Random number between given value
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		WebElement UserNameInputbox = driver.findElement(By.id("systemUser_userName"));
		UserNameInputbox.sendKeys("nadim" + randomInt);
		String EnteredValue = UserNameInputbox.getAttribute("value");
		// driver.findElement(By.id("systemUser_userName")).sendKeys("sivaharsha");
		driver.findElement(By.id("systemUser_password")).sendKeys("harshaaa");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("harshaaa");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);
		//Search Added User
		driver.findElement(By.name("searchSystemUser[userName]")).sendKeys(EnteredValue);
		driver.findElement(By.id("searchBtn")).click();
		//Delete Added User
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();

	}
	
	@Test
	public void searchUser() {
		
	}
	
	@Test
	public void deleteUser() {
		
	}
}
