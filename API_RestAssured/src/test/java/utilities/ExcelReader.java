package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 

public class ExcelReader {

	 private static String filePath;
		    private static String sheetName;
	
		    public ExcelReader(String filePath, String sheetName) {
		        ExcelReader.filePath = filePath;
		        ExcelReader.sheetName = sheetName;
		    }
	
			public static List<List<String>> readExcelData() throws IOException {
		        List<List<String>> data = new ArrayList<>();
		        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
		        Workbook workbook = WorkbookFactory.create(fileInputStream);
		        Sheet sheet = workbook.getSheet(sheetName);
		        
		        for (Row row : sheet) {
		            List<String> rowData = new ArrayList<>();
		            for (Cell cell : row) {
		                rowData.add(cell.toString());
		            }
		            data.add(rowData);
		        }
	
		        workbook.close();
		        fileInputStream.close();
		        return data;
		    }
		}
	
	
	
 
	 

