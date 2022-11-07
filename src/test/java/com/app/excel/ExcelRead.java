package com.app.excel;

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

public class ExcelRead {

	public static void excelRead() {
		// file read
		try {
			// file -> locate
			File f = new File("C:\\Users\\Yuvaraj\\eclipse-workspace\\Oct_SampleProject\\src"
					+ "\\test\\resources\\TestData\\Oct_TestData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			// workbook interface
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(1);
			System.out.println(cell);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void excelAllRead() {
		// file read
		try {
			// file -> locate
			File f = new File("C:\\Users\\Yuvaraj\\eclipse-workspace\\Oct_SampleProject\\src"
					+ "\\test\\resources\\TestData\\Oct_TestData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			// workbook interface
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			// to print the entire row
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for (int i = 0; i < physicalNumberOfRows; i++) {
				Row row = sheet.getRow(i);
				// to print the entire cell
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				for (int j = 0; j < physicalNumberOfCells; j++) {
					Cell cell = row.getCell(j);
					System.out.println(cell);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void excelformatRead() {
		// file read
		try {
			// file -> locate
			File f = new File("C:\\Users\\Yuvaraj\\eclipse-workspace\\Oct_SampleProject\\src"
					+ "\\test\\resources\\TestData\\Oct_TestData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			// workbook interface
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			// to print the entire row
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for (int i = 0; i < physicalNumberOfRows; i++) {
				Row row = sheet.getRow(i);
				// to print the entire cell
				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
				for (int j = 0; j < physicalNumberOfCells; j++) {
					Cell cell = row.getCell(j);
					// System.out.println(cell);
					int cellType = cell.getCellType();
					if (cellType == 1) {
						String value = cell.getStringCellValue();
						System.out.println(value);
					} else if (cellType == 0) {
						if (DateUtil.isCellDateFormatted(cell)) {
							Date dateCellValue = cell.getDateCellValue();
							SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy");
							String format = sf.format(dateCellValue);
							System.out.println(format);
						} else {
							double d = cell.getNumericCellValue();
							long l = (long) d;
							String number = String.valueOf(l);
							System.out.println(number);
						}
					}

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
					//String value= sf.format(dateCellValue);
					value= sf.format(dateCellValue);
					System.out.println(value);
				}else {
					double numericCellValue = cell2.getNumericCellValue();
					long l = (long)numericCellValue;
					//String value= String.valueOf(l);
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

	public static void main(String[] args) {
		excelreuseRead(1,1);
	}
}
