package com.app.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void browserlaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yuvaraj\\eclipse-workspace\\Oct_SampleProject"
				+ "\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void url(String url) {
		driver.get(url);
	}
	
	public static void sendkeys(WebElement element , String data) {
		element.sendKeys(data);
	}
	
	public static void clickdata(WebElement element ) {
		element.click();
	}
	
	public static WebElement findElementid(String id) {
		return driver.findElement(By.id(id));	
	}
	
	public static WebElement findElemenname(String name) {
		return driver.findElement(By.name(name));	
	}
	
	public static void selectbyvalue(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByValue(data);
	}

	public static void selectbyindex(WebElement element, int data) {
		Select s = new Select(element);
		s.selectByIndex(data);
	}
	
	// Abstract method
	
	public static WebElement findElementBy(By by) {
		return driver.findElement(by);	
	}
	
	public static String excelreuseRead(int row,int cell) {
		String value = null;
		// file read
		try {
			// file -> locate
			File f = new File("C:\\Users\\Yuvaraj\\eclipse-workspace\\Oct_SampleProject\\src"
					+ "\\test\\resources\\TestData\\Oct_TestData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			// workbook interface
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row2 = sheet.getRow(row);
			Cell cell2 = row2.getCell(cell);
			int type = cell2.getCellType();
			if(type==1) {
				 value = cell2.getStringCellValue();
				 System.out.println(value);
			}else if(type==0) {
				if(DateUtil.isCellDateFormatted(cell2)) {
					Date dateCellValue = cell2.getDateCellValue();
					SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy");
					value= sf.format(dateCellValue);
					System.out.println(value);
				}else {
					double numericCellValue = cell2.getNumericCellValue();
					long l = (long)numericCellValue;
					value = String.valueOf(l);
					System.out.println(value);
				}
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}


	
	
}
