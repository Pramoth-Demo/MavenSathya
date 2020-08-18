package com.sathya.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sathya.base.BaseClass;
import com.sathya.pages.ProductsPage;
import com.sathya.pages.AddToCartPage;
import com.sathya.pages.HomePage;
import com.sathya.pages.LogInPage;

public class TestProducts extends BaseClass{
	ProductsPage productsPage;
	LogInPage login;
	HomePage homePage;
	AddToCartPage addToCartPage;
	

	public TestProducts() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		browserLaunch();
		login=new LogInPage();
		homePage=new HomePage();
		productsPage =new ProductsPage();
		addToCartPage=new AddToCartPage();
		login.logIn(properties.getProperty("email"), properties.getProperty("password"));
		homePage.clickOnProductsLink();
		
	}
	
	@Test
	public void clickOnCoffeeMaker() throws IOException, InterruptedException 
	{
		
	productsPage.clickAllProducts();
	
	addToCartPage=productsPage.clickOnProductToBePlaced();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
