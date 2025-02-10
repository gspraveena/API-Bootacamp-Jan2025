package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutility {

	 
	static String path;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static String excelURL = "/Users/praveenag/Desktop/API/excel1New.xlsx";
	private final DataFormatter dataFormatter;

	
	public excelutility(String excelURL, String sheetName)
	{
			
		this.dataFormatter = new DataFormatter();
	try {

	path=System.getProperty("user.dir");
	
	workbook= new XSSFWorkbook(excelURL);
	
	sheet= workbook.getSheet(sheetName);
	workbook.close();

	}catch(Exception e) {

	e.printStackTrace();
	}	
	}
	public static void main(String[] args)
	{
		getRowCount();
	}
	public static void getCellData()
	{
try {
			
	 	
			XSSFWorkbook workbook= new XSSFWorkbook(excelURL);
			XSSFSheet sheet=workbook.getSheet("excel1New");
			
			String value=sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(value);
			
} catch (Exception exp) {
	 System.out.println(exp.getMessage());
	 System.out.println(exp.getCause());
	exp.printStackTrace();
}
	}
	public static void getRowCount()
	{
		try {
			
			path = System.getProperty("user.dir");
		
			XSSFWorkbook workbook= new XSSFWorkbook(path+excelURL);
			XSSFSheet sheet=workbook.getSheet("excel1New");
			
			int rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows:"+ rowCount);
		} catch (Exception exp) {
			 System.out.println(exp.getMessage());
			 System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	public static String getCellDataString(int rowNum, int cellNum) {

		String cellData=" ";
	try {

		 cellData= sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		 System.out.println(cellData);
		 return cellData;
		}
	catch(Exception exp) {
		System.out.println(exp.getMessage());
		System.out.println(exp.getCause());
		exp.printStackTrace();
		return cellData;
		}

	}
	public String getCellDataString2(int rowNumber, int columnNumber) {
        Cell cell = sheet.getRow(rowNumber).getCell(columnNumber);
        System.out.println("Cell Vlaue" +cell);

        
        if (cell != null) {
        	
            return dataFormatter.formatCellValue(cell);
        }
        return "";
    }
	 

}
