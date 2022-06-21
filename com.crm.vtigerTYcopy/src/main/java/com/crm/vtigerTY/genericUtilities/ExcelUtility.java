package com.crm.vtigerTY.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Hemanth
 *
 */
public class ExcelUtility {
	/**
	 * It is used read the data from excel file
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetname,int rowNumber,int cellNumber) throws Throwable 
	{
		FileInputStream fileInputStream = new FileInputStream("./src\\test\\resources\\Exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowNumber);
		String text = row.getCell(cellNumber).toString();
		return text;
	}
	/**        
	 * 
	 * It is used to write data to excel file
	 * @throws Throwable
	 */
	public void WriteDateIntoExcel(String sheetName,int rowNumber,int cellNumber,String data) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream("./src\\test\\resources\\Exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		cell.setCellValue(data);
		FileOutputStream fout = new FileOutputStream("./src\\test\\resources\\Exceldata.xlsx");
		book.write(fout);
	}
	/**
	 * to get the numerical value
	 * @param sheetname
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws Throwable
	 */
	public String getNumericalData(String sheetname,int rowNumber,int cellNumber) throws Throwable 
	{
		FileInputStream fileInputStream = new FileInputStream("./src\\test\\resources\\Exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(cellNumber);
		DataFormatter data = new DataFormatter();
		String number = data.formatCellValue(cell);
		return number;
	}
	/**
	 * to get the numerical data along with string data's
	 * @param sheetname
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws Throwable
	 */
	public double getdoubleNumericalExcelData(String sheetname,int rowNumber,int cellNumber) throws Throwable 
	{
		FileInputStream fileInputStream = new FileInputStream("./src\\test\\resources\\Exceldata.xlsx");
		Workbook book = WorkbookFactory.create(fileInputStream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowNumber);
		 Cell cell = row.getCell(cellNumber);
		 double value = cell.getNumericCellValue();
		return value;
		
	}
}
