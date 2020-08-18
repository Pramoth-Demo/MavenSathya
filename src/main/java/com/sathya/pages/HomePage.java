package com.sathya.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sathya.base.BaseClass;

public class HomePage extends BaseClass {
	 WebDriverWait wait;
	 Actions action;
	
	
	@FindBy(xpath="(//a[@class='nav-link dropdown-toggle'])[1]")
	WebElement HomeAppliances;
		
	@FindBy(id="megamenu-subitem-49")
	WebElement CoffeeMaker;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	

	
	public ProductsPage clickOnProductsLink() throws InterruptedException, IOException {
	     
	     action=new Actions(driver);
	     action.moveToElement(HomeAppliances).build().perform();
	     
	     wait = new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOf(CoffeeMaker)).click();
	     
	    return new ProductsPage();
		
	}

}
