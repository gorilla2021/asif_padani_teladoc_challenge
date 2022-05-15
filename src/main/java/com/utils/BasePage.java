package com.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public void input(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void selectDropDownByValie(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public boolean isElementPresent(By by) {
		try {
			return getDriver().findElement(by).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
