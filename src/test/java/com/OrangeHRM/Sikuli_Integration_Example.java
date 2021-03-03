
package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sikuli_Integration_Example {

	ChromeDriver driver;

	@BeforeTest
	public void LaunchBrowser() {
		ChromeOptions chromeOptions = new ChromeOptions();
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("localhost:8080");
		chromeOptions.setProxy(proxy);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
	}

	@Test
	public void LoginSuccesful_Scenarion() throws InterruptedException {
		String filePath = System.getProperty("user.dir") + "\\Sikuli_Objects\\";
		Screen s = new Screen();
		Pattern fileInputTextBox = new Pattern(filePath + "TextBoxNew.PNG");
		Pattern openButton = new Pattern(filePath + "Button.png");
		driver.manage().window().maximize();

		driver.get("https://gofile.io/uploadFiles");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='dropZoneBtnSelect']")).click();

		try {
			s.wait(fileInputTextBox, 20);
			s.type(fileInputTextBox, filePath + "sign.jpg");
			s.click(openButton);

			// Close the browser // driver.close();

		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

}
