package com.sathya.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sathya.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-lg btn-block btn-add-to-cart ajax-cart-link']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-flat btn-flat-light btn-block btn-action']")
	WebElement goToCartButton;
	


	public AddToCartPage() throws IOException {
		
		PageFactory.initElements(driver, this);	
	}
	
	public BillingAddressPage addToCart() throws InterruptedException, IOException {
		
		addToCartButton.click();
		Thread.sleep(2000);
		goToCartButton.click();
		
		return new BillingAddressPage();
	}
	
	
	

}
