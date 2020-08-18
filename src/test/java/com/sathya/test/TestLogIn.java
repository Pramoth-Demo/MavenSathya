package com.sathya.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sathya.base.BaseClass;
import com.sathya.pages.LogInPage;


public class TestLogIn extends BaseClass {
	LogInPage login;


	public TestLogIn() throws IOException {
		super();
		
	}
	
	@BeforeMethod 
	public void launchBrowser() {
		browserLaunch();	
	}
	
	@Test
	public void logIn() throws IOException, InterruptedException {
	   
		login=new LogInPage();
		login.logIn(properties.getProperty("email"),properties.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
