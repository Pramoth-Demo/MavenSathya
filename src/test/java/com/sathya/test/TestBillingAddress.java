package com.sathya.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.sathya.base.BaseClass;
import com.sathya.pages.BillingAddressPage;
import com.sathya.pages.HomePage;
import com.sathya.pages.AddToCartPage;
import com.sathya.pages.ProductsPage;
import com.sathya.pages.LogInPage;

public class TestBillingAddress extends BaseClass {
	BillingAddressPage billingAddress;
	ProductsPage productsPage;
	LogInPage login;
	HomePage homePage;
	AddToCartPage addToCartPage;

	public TestBillingAddress() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		browserLaunch();
		LogInPage login=new LogInPage();
		homePage=new HomePage();
		productsPage=new ProductsPage();
		addToCartPage=new AddToCartPage();
		billingAddress=new BillingAddressPage();
		login.logIn(properties.getProperty("email"), properties.getProperty("password"));
		productsPage=homePage.clickOnProductsLink();
		addToCartPage=productsPage.clickOnProductToBePlaced();
		addToCartPage.addToCart();
	}
	
	@Test
	public void FeedingBillingAddress() throws IOException {
		
		billingAddress.feedingBillingAddress();
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
