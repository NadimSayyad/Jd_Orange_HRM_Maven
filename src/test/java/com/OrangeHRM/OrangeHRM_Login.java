package com.OrangeHRM;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login {

	@Test
	public void LoginSuccesful_Scenarion() throws InterruptedException {
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.findElement(By.linkText("My Info")).isDisplayed();
		String name = driver.findElement(By.id("Subscriber_link")).getTagName();
		System.out.println(name);
		//driver.close(); //Close the current browser
		driver.quit();

	}

}