package com.sathya.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sathya.base.BaseClass;
import com.sathya.util.ExcelRead;

public class BillingAddressPage extends BaseClass {
	
	WebDriverWait wait;
	ExcelRead read;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	@FindBy(id="NewAddress_FirstName")
	WebElement firstName;
	@FindBy(id="NewAddress_LastName")
	WebElement lastName;
	@FindBy(id="NewAddress_Address1")
	WebElement address1;
	@FindBy(id="NewAddress_Address2")
	WebElement address2;
	@FindBy(id="NewAddress_City")
	WebElement city;
	@FindBy(id="NewAddress_ZipPostalCode")
	WebElement postalCode;
	@FindBy(xpath="(//select[@class='form-control select2-hidden-accessible'])[1]")
	WebElement country;
	@FindBy(xpath="(//select[@class='form-control select2-hidden-accessible'])[2]")
	WebElement state;
	@FindBy(id="NewAddress_Email")
	WebElement email;
	@FindBy(id="NewAddress_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(xpath="//button[@class='btn btn-warning btn-lg new-address-next-step-button']")
	WebElement nextButton;
	
	

	
	
	public BillingAddressPage() throws IOException {
		PageFactory.initElements(driver, this);
	
	}
	
	public void feedingBillingAddress() throws IOException {
		
		checkoutButton.click();
		
		read=new ExcelRead();

		firstName.sendKeys(read.firstName);
		lastName.sendKeys(read.lastName);
		address1.sendKeys(read.address1);
		address2.sendKeys(read.address2);
		city.sendKeys(read.city);
		postalCode.sendKeys(read.postalCode);
		
		wait = new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.visibilityOf(country));
		Select selectCountry=new Select(country);
		selectCountry.selectByVisibleText("India");
		
		wait.until(ExpectedConditions.visibilityOf(state));
		Select selectState=new Select(state);
		selectState.selectByVisibleText("Tamilnadu");
		
		email.sendKeys(read.email);
		phoneNumber.sendKeys(read.phoneNumber);
		
		nextButton.click();
		
	
	}
	
	
	
	

}
