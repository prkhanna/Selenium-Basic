package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Home {
	
	HomePage bookingPage;
	
	public Home(HomePage bookingPage) {
        this.bookingPage = bookingPage;
    }

	
	
	@Given("User Fill in all the mandatory fields on the page")
	public void fillFields() {
		bookingPage.fillDetails();
	}
	
	@Given("Click on submit button")
	public void clickSubmit() {
		bookingPage.clickSubmitButton();
	}
	
//	@Given("Verify the final data")
//	public void dualInput() {
//		bookingPage.getDataBinding();
//	}
	
	@Given("Verify the conf message")
	public void CfMsg() {
		bookingPage.successMsg();
	}
	



}
