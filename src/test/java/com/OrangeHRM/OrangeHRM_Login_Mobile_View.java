package com.OrangeHRM;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Mobile_View {
	ChromeDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		Dimension dimension = new Dimension(640, 960);
		driver.manage().window().maximize();
		driver.manage().window().setSize(dimension);
		driver.navigate().to("https://www.borrowlenses.com/");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void LoginSuccesful_Scenarion() throws InterruptedException {
		Thread.sleep(15000);
		//driver.close(); //Close the current browser
		driver.quit();

	}

}