package com.stepdefinitation;

import com.utils.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setUp() throws Exception {
		WebDriverFactory.setupDriver();
	}

	@After
	public void tearDown() {
		WebDriverFactory.getDriver().quit();
	}

}