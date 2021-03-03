package com.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parellel_Thread_Example {
	WebDriver driver;

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void ChromeTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(10000);
		
		driver.quit();

	}

	@Test
	public void EdgeTest() throws InterruptedException {

		// Initialize the Edge driver
		WebDriverManager.edgedriver().setup();
		System.out.println("The thread ID for Edge is " + Thread.currentThread().getId());
		driver = new EdgeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(10000);
		
		driver.quit();

	}
}
