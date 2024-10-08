package com.qa.auto.pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionalLibrary;

/**
 * 
 * @author Prince Khanna
 *
 */
public class SummaryPage {

	FunctionalLibrary misc;

	public SummaryPage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionalLibrary(browserFctry);
	}

	@FindBy(xpath = "//h4[text()='Booking successful']")
	public static WebElement bookingText;
	
	@FindBy(xpath = "//p[contains(text(),' booking confirmation')]")
	public static WebElement confirmationMessage;

	public void validateBooking() {
		String actualText = misc.elementGetText(bookingText);
		String expectedText = "Booking successful";
		Assert.assertEquals(actualText, expectedText);
	}
	
	public void confirmationMessage() {
		JSONObject data = misc.getJsonData();
		String actualText = misc.elementGetText(confirmationMessage);
		String expectedText =  data.get("email").toString();
		Assert.assertTrue( actualText.contains(expectedText));
	}

}
