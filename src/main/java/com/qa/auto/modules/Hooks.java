package com.qa.auto.modules;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionalLibrary;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * This class is the staring point of the application
 * 
 * @author Prince Khanna
 *
 */
public class Hooks {
	WebDriver driver;
	BrowserFactory brwsFactory;
	FunctionalLibrary misc;

	public Hooks(BrowserFactory brwsFactory) {
		this.brwsFactory = brwsFactory;
	}

	@Before
	public void bf() {
		brwsFactory.setDriver();
		misc = new FunctionalLibrary(brwsFactory);
		Properties prop = misc.readData();
		String url = prop.getProperty("URL");
		brwsFactory.getDriver().get(url);
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			misc.getScreenshot(scenario);
		}

		brwsFactory.getDriver().quit();
	}

}