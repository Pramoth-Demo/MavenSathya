package com.sathya.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sathya.base.BaseClass;

public class LogInPage extends BaseClass{
	
//	          @FindBy(xpath="(//a[@class='menubar-link'])[3]")
//	          WebElement loginIcon;
	          
	          @FindBy(xpath="//input[@id='Email']")
	          WebElement emailField;
	          
	          @FindBy(xpath="//input[@id='Password']")
	          WebElement passwordField;
	          
	          @FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-block btn-login']")
	          WebElement loginButton;
	
	
	
	
	

	

	public LogInPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage logIn(String email,String pw) throws InterruptedException, IOException {
		

//		loginIcon.click();
		
		emailField.sendKeys(email);
		passwordField.sendKeys(pw);
		loginButton.click();
		
		return new HomePage();
		
		
            
		
	}
	
	
	
	
	
	
	
	
	
	

}
