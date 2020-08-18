package com.sathya.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.sathya.base.BaseClass;
import com.sathya.pages.HomePage;
import com.sathya.pages.LogInPage;
import com.sathya.pages.ProductsPage;

public class TestHomePage extends BaseClass {
	LogInPage logInPage;
	HomePage homePage;
	ProductsPage productsPage;
     
	
	public TestHomePage() throws IOException {
		super();

	    }

	 @Test
     public void clickOnProduct() throws IOException, InterruptedException {
		browserLaunch();
		logInPage = new LogInPage();
		logInPage.logIn(properties.getProperty("email"), properties.getProperty("password"));
		homePage = new HomePage();
	    homePage.clickOnProductsLink();
			

	     }

   
	    

    @AfterMethod
	    public void tearDown() {
		driver.quit();
	   }

}

