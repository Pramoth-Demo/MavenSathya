package com.sathya.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.sathya.pages.ProductsPage;

public class ExcelWrite {
	ProductsPage products;
	static int dummyHeaders=0;
	static int dummyValues=1;
	static int counterHeaders=0;
	static int counterValues=0;
	
	/**
	 * @throws IOException
	 */
	public void FeaturesHeaders() throws IOException {
		
//		File source=new File("C:\\Users\\Naren DL\\Desktop\\Sathya\\Sathya.xlsx");
		File source=new File("C:\\Users\\Naren DL\\eclipse-workspace\\MavenSathya\\src\\main\\java\\com\\sathya\\config\\Sathya1.xlsx");
        FileInputStream fis=new FileInputStream(source);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Products_Features");
        products=new ProductsPage();

      List<WebElement> headers=products.FeaturesHeaders;
      sheet.createRow(dummyHeaders);
        for(int i=0;i<headers.size();i++) {
        	
        String data=headers.get(i).getText().toString();
        
        XSSFCell cell=sheet.getRow(dummyHeaders).createCell(i); 
        cell.setCellValue(data);
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();                 // Creating Font
        font.setFontName("Bookman");
        font.setItalic(true);
        font.setBold(true);
        style.setFont(font);                                   // Applying Font to the Style
        cell.setCellStyle(style);                              // Applying Style to the Cell
        
        }
        counterHeaders++;
        
        if(counterHeaders>0) {
         dummyHeaders=dummyHeaders+2;
        }
       
        FileOutputStream fos=new FileOutputStream(source);
        workbook.write(fos);
        fos.close();   
    
	}
	
	public void FeaturesValues() throws IOException {
		
//		File source=new File("C:\\Users\\Naren DL\\Desktop\\Sathya\\Sathya.xlsx");
		File source=new File("C:\\Users\\Naren DL\\eclipse-workspace\\MavenSathya\\src\\main\\java\\com\\sathya\\config\\Sathya1.xlsx");
        FileInputStream fis=new FileInputStream(source);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Products_Features");
    
        products=new ProductsPage();

      List<WebElement> values=products.FeaturesValues;
      sheet.createRow(dummyValues);

        for(int i=0;i<values.size();i++) {
        	
        
        String data=values.get(i).getText().toString();
       
        sheet.getRow(dummyValues).createCell(i).setCellValue(data); 	
        
        }
        counterValues++;
        
        if(counterValues>0) {
        	dummyValues=dummyValues+2;
        }
       
        FileOutputStream fos=new FileOutputStream(source);
        workbook.write(fos);
        fos.close();   
		
	}
	
	

}
