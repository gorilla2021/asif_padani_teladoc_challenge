package com.stepdefinitation;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.model.UserData;
import com.pages.WebTablePage;
import com.utils.Configuration;
import com.utils.WebDriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {

	private WebTablePage webTablePage;

	public UserSteps() {
		webTablePage = PageFactory.initElements(WebDriverFactory.getDriver(), WebTablePage.class);
	}

	@Given("I am on webtables page")
	public void i_am_on_webtables_page() throws IOException {
		String url = Configuration.getConfig("BaseUrl");
		WebDriverFactory.getDriver().navigate().to(url + "/angularjs-protractor/webtables");
	}

	@When("I clicked on Add user button")
	public void i_clicked_on_add_user_button() {
		webTablePage.clickAddUserButton();
	}


	@When("I fill user details FirstName {string} LastName {string} UserName {string} Password {string} Customer {string} Role {string} Email {string} Cell {string}")
	public void fillForm(String firstName, String lastName, String userName, String password, String customer,
			String role, String email, String cell) {
		UserData userData = new UserData();
		userData.setFirstName(firstName);
		userData.setLastName(lastName);
		userData.setUserName(userName);
		userData.setPassword(password);
		userData.setCustomer(customer);
		userData.setRole(role);
		userData.setEmail(email);
		userData.setCell(cell);
		webTablePage.fillUserForm(userData);
	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		webTablePage.clickOnSaveButton();
	}
	
	
	@Then("I verified user FirstName {string} with email {string} is added")
	public void i_verified_user_added(String firstname, String email) {
		webTablePage.verifyUserAdded(firstname, email);
	}


	@When("I delete user {string} from list of users")
	public void i_delete_user_from_list_of_user(String userName) {
		webTablePage.deleteUser(userName);
	}

	@Then("I verified user {string} is deleted")
	public void i_verified_user_is_deleted(String userName) {
		webTablePage.verifyDeleted(userName);
	}

}
