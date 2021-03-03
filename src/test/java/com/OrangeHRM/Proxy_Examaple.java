package com.OrangeHRM;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proxy_Examaple {
	WebDriver driver;

	@Test
	public void HTTPAuth() throws InterruptedException {
		System.out.println("Proxy Setting Done");

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@BeforeTest
	public void LaunchBrowser() {
		ChromeOptions chromeOptions = new ChromeOptions();
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("localhost:8080");
		chromeOptions.setProxy(proxy);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void CloseBrowser() {
		// driver.quit();
	}
}
