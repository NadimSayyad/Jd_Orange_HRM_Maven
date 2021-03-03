package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetBankingHDFC_Test {
	ChromeDriver driver;

	@BeforeTest
	public void before() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(true);
		driver = new ChromeDriver();
		driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void login_HDFC() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame("login_page");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr/td/a/img[1]")));
		driver.findElementByXPath("//input[@name='fldLoginUserId']").sendKeys("1000");
		driver.findElementByXPath("//tbody/tr/td/a/img[1]").click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElementByLinkText("Terms and Conditions").click();

	}
}
