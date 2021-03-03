package com.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange_HRM_Read_prop_Example {
	
	ChromeDriver driver;
	
	@BeforeTest
    public void LaunchBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:8080");
        chromeOptions.setProxy(proxy);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }
	
	
	@Test(priority = 1)
	public void Login() throws InterruptedException, IOException {
		Thread.sleep(2000);
		
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\resource\\objectRepo.properties");
		
		Properties properties = new Properties();
		
		FileInputStream fileInputStream =  new FileInputStream(file);
		
		properties.load(fileInputStream);
			
		// Launch the browser
		driver.findElement(By.xpath(properties.getProperty("iUserNameXpath"))).sendKeys("Admin");
		driver.findElement(By.cssSelector(properties.getProperty("iPasswordCssSelector"))).sendKeys("admin123");
		driver.findElement(By.id(properties.getProperty("btLoginId"))).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.findElement(By.linkText("My Info")).isDisplayed();
		// driver.close(); //Close the current browser
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
