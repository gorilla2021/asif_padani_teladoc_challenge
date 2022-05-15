package com.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	public enum DriverType {
		Firefox, Edge, Chrome
	}

		
	private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
	
	public static void setupDriver() throws Exception {
		WebDriver driver = null;
		String browserType = Configuration.getConfig("BrowserType");
		if (DriverType.Firefox.toString().toLowerCase().equals(browserType.toLowerCase())) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (DriverType.Edge.toString().toLowerCase().equals(browserType.toLowerCase())) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (DriverType.Chrome.toString().toLowerCase().equals(browserType.toLowerCase())) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
		} else {
			throw new Exception("Please pass a valid browser type value");
		}
		
		webdriver.set(driver);
		webdriver.get().manage().window().maximize();
		webdriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static WebDriver getDriver() {
		return webdriver.get();
	}	
}
