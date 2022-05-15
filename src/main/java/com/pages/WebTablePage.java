package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.model.UserData;
import com.utils.BasePage;

public class WebTablePage extends BasePage {

	public WebTablePage(WebDriver driver) {
		super(driver);	
	}

	@FindBy(css = "button[type='add']")
	private WebElement addUserButton;
	
	@FindBy(css = "[name='FirstName']")
	private WebElement firstNameinput;
	
	@FindBy(css = "[name='LastName']")
	private WebElement lastNameInput;
	
	@FindBy(css = "[name='UserName']")
	private WebElement userNameInput;
	
	@FindBy(css = "[name='Password']")
	private WebElement passwordInput;
	
	@FindBy(css = "[name='RoleId']")
	private WebElement roleDropDown;
	
	@FindBy(css = "[name='Email']")
	private WebElement emailInput;
	
	@FindBy(css = "[name='Mobilephone']")
	private WebElement cellPhoneInput;
	
	@FindBy(css = "button[ng-click='save(user)']")
	private WebElement saveButton;
		
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement deleteOkButton;
			
	public void clickAddUserButton() {
		clickOn(addUserButton);
	}
	
	public void fillUserForm(UserData data) {
		String customerLocator = "//label[text()='Company AAA']";
		input(firstNameinput, data.getFirstName());
		input(lastNameInput, data.getLastName());
		input(userNameInput, data.getUserName());
		input(passwordInput, data.getPassword());
		clickOn(getDriver().findElement(By.xpath(customerLocator)));
		selectDropDownByValie(roleDropDown, data.getRole());
		input(emailInput, data.getEmail());
		input(cellPhoneInput, data.getCell());		
	}
	
	public void clickOnSaveButton() {
		clickOn(saveButton);
	}
	
	public void verifyUserAdded(String firstName, String email) {
		String locator = "//tr[td[text()='"+firstName+"']]/td[text()='"+email+"']";		
		boolean status = isElementPresent(By.xpath(locator));
		Assert.assertTrue(status, "User is not added");
	}
	
	public void deleteUser(String userName) {
		String locator = "//tr[td[text()='"+userName+"']]/td/button[@ng-click='delUser()']";
		clickOn(getDriver().findElement(By.xpath(locator)));
		clickOn(deleteOkButton);
	}
	
	
	public void verifyDeleted(String userName) {
		String locator = "//tr[td[text()='"+userName+"']]";
		boolean status = isElementPresent(By.xpath(locator));
		Assert.assertFalse(status, "User is not deleted");
	}
	
}
