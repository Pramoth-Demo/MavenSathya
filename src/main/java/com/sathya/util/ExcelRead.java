package com.sathya.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	           public  String firstName;
	           public  String lastName;
	           public  String address1;
	           public  String address2;
	           public  String city;
	           public  String postalCode;
	           public  String email;
	           public  String phoneNumber;
	
	public ExcelRead() throws IOException {
		
	
//	            File source=new File("C:\\Users\\Naren DL\\Desktop\\Sathya\\Sathya.xlsx");
	            File source=new File("C:\\Users\\Naren DL\\eclipse-workspace\\MavenSathya\\src\\main\\java\\com\\sathya\\config\\Sathya1.xlsx");
                FileInputStream fis=new FileInputStream(source);
                XSSFWorkbook workbook=new XSSFWorkbook(fis);
                XSSFSheet sheet=workbook.getSheet("Billing_Address");
                
                DataFormatter formatter = new DataFormatter();
                
               
                firstName   = sheet.getRow(1).getCell(0).getStringCellValue();
                lastName    = sheet.getRow(1).getCell(1).getStringCellValue();
                address1    = sheet.getRow(1).getCell(2).getStringCellValue();
                address2    = sheet.getRow(1).getCell(3).getStringCellValue();
                city        = sheet.getRow(1).getCell(4).getStringCellValue();
                postalCode= formatter.formatCellValue(sheet.getRow(1).getCell(5));
//              postalCode  = sheet.getRow(1).getCell(5).getStringCellValue();
                email       = sheet.getRow(1).getCell(6).getStringCellValue();
                phoneNumber = formatter.formatCellValue(sheet.getRow(1).getCell(7));
//              phoneNumber = sheet.getRow(1).getCell(7).getStringCellValue();
                
}
}