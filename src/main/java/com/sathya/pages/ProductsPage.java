package com.sathya.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sathya.base.BaseClass;
import com.sathya.util.ExcelWrite;

public class ProductsPage extends BaseClass {
	 ExcelWrite excelWrite;
	 Actions action;
	

	
    @FindBy(xpath="//article[@class='art']")
    List<WebElement> CoffeeMakers;
    
    @FindBy(xpath="(//li[@class='nav-item'])[3]")
    WebElement ProductFeatures;
    
    @FindBy(xpath="//table[@class='table pd-specs-table']")
    WebElement FeaturesTable;
    
    @FindBy(xpath="//td[@class='pd-spec-name']")
    public List<WebElement> FeaturesHeaders;
    
    @FindBy(xpath="//td[@class='pd-spec-value']")
    public List<WebElement> FeaturesValues;
    
    @FindBy(xpath="//article[@class='art'][1]")
    WebElement ProductToBePlaced;
    
    
	
	public ProductsPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
		
	}
	public void clickAllProducts() throws IOException {
		
     for(WebElement cm:CoffeeMakers) {
    	
    	 try {
    		 
    		 action=new Actions(driver);
    		 
    		 action.keyDown(Keys.CONTROL).click(cm).keyUp( Keys.CONTROL).build().perform(); 
    		 
    		 Set<String> windows=driver.getWindowHandles();
    		 Iterator<String> iterator=windows.iterator();
    		 String parent= iterator.next(); 
    		 driver.switchTo().window(parent);
    		 String child=iterator.next();
             driver.switchTo().window(child);
        		
    		 ProductFeatures.click();
    		 excelWrite=new ExcelWrite();
    		 excelWrite.FeaturesHeaders();  // Calling write Features Headers method
    		 excelWrite.FeaturesValues();   // Calling write Features Values method
    		 driver.close();
    		 driver.switchTo().window(parent);
	 
    	 }
    	 catch(StaleElementReferenceException e) {
    		 e.getMessage();
       	 
    	 }}
    
	}
	
public AddToCartPage clickOnProductToBePlaced() throws IOException {
	
	ProductToBePlaced.click();
	return new AddToCartPage();
}

	
	

	
	
	
	
	
	
	
	
	
	

}
