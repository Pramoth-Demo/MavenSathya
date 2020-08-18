package com.sathya.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	  public static Properties properties;
	  public static WebDriver driver;
	public BaseClass() throws IOException {
                       		
		          properties=new Properties();
		          FileInputStream input=new FileInputStream("C:\\Users\\Naren DL\\eclipse-workspace\\Mavensathya\\src\\main\\java\\com\\sathya\\config\\config.prop");
		          properties.load(input);
	}
	
	public void browserLaunch() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
