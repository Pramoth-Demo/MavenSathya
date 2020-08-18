package com.sathya.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.sathya.base.BaseClass;
import com.sathya.pages.AddToCartPage;
import com.sathya.pages.BillingAddressPage;
import com.sathya.pages.HomePage;
import com.sathya.pages.ProductsPage;
import com.sathya.pages.LogInPage;

public class TestAddToCartPage extends BaseClass {
	LogInPage login;
	HomePage homePage;
	ProductsPage productsPage;
	AddToCartPage addToCartPage;
	BillingAddressPage billingAddress;

	public TestAddToCartPage() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void launchBrowser() throws IOException, InterruptedException {
		browserLaunch();
		login=new LogInPage();
		homePage=new HomePage();
		productsPage=new ProductsPage();
		login.logIn(properties.getProperty("email"), properties.getProperty("password"));
		productsPage=homePage.clickOnProductsLink();
		addToCartPage=productsPage.clickOnProductToBePlaced();
		
		
	}
	
	@Test
	public void ProductCheckOut() throws InterruptedException, IOException {
		addToCartPage.addToCart();

	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	

}
