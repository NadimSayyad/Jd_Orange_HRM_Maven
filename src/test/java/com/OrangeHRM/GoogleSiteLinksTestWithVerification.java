package com.OrangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSiteLinksTestWithVerification {

	WebDriver driver;

	@BeforeTest
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.co.in/");
	}

	@AfterTest
	public void after() {
		driver.quit();
	}

	@Test
	public void Login() throws InterruptedException {
		Thread.sleep(5000);

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		int linksCount = allLinks.size();
		System.out.println("Total no of links Available:" + linksCount);
		// Create String array of total linkcount
		String[] links = new String[linksCount];
		System.out.println("List of links Available:");
		// print all the links from webpage
		for (int i = 0; i < linksCount; i++) {

			links[i] = allLinks.get(i).getAttribute("href");
			System.out.println(allLinks.get(i).getAttribute("href"));
		}
		// navigate to each Link on the webpage
		for (int i = 0; i < linksCount; i++) {
			driver.navigate().to(links[i]);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			// driver.navigate().back();

		}

	}
}
