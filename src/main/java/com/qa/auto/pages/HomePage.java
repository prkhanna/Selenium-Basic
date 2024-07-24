package com.qa.auto.pages;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.gson.JsonObject;
import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionalLibrary;

/**
 * 
 * @author Prince Khanna
 *
 */
public class HomePage {

	FunctionalLibrary misc;
	JSONObject data;
	public HomePage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionalLibrary(browserFctry);
		data= misc.getJsonData();
	}
	
	@FindBy(xpath = "//label //following-sibling::input[@name= 'name']")
	public static WebElement name;

	@FindBy(xpath = "//input[@name= 'email']")
	public static WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public static WebElement password;
	
	@FindBy(xpath = "//input[@type= 'checkbox']")
	public static WebElement checkOut;

	@FindBy(xpath = "//input[@type= 'checkbox']")
	public static WebElement gender;

	@FindBy(xpath = "//input[@id='inlineRadio1']")
	public static WebElement employmentStatus;

	@FindBy(xpath = "//input[@name='bday']")
	public static WebElement dob;

	@FindBy(xpath = "//input[@value='Submit']")
	public static WebElement submit;

	@FindBy(xpath = "//h4 //following-sibling::input[@name= 'name']")
	public static WebElement twoWayInput;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public static WebElement successMsg;

	public void fillDetails() {
		misc.elementSendKeys(name, data.get("firstName").toString());
		misc.elementSendKeys(email, data.get("email").toString());
		misc.elementSendKeys(password, data.get("lastName").toString());
		misc.elementClick(checkOut);
		misc.elementSendKeys(dob, data.get("dob").toString());
		misc.elementClick(employmentStatus);
		
	}

	public void clickSubmitButton() {
		misc.elementClick(submit);
	}

	public void getDataBinding() {
		misc.wait(2000);;
	String actualText = misc.elementGetText(twoWayInput);
	System.out.println( "aaaaaaaaa" + actualText );
	String expectedText =  data.get("firstName").toString();
	System.out.println( "hheeee" + expectedText );
	Assert.assertEquals(actualText, expectedText);
		
	}

	public void successMsg() {
		 String actual= misc.elementGetText(successMsg);
		 
		 System.out.println("dfsgdssdgdssd "+ actual);
		 String expected =  data.get("successMsg").toString();
		 System.out.println("Hellllll "+ expected);
		 assertTrue(actual.contains(expected));
		
		
	}

	




}
