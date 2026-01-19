package utilities;

import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelData {
	
	public static String readData(int row, int col) {
		
		String value="";		
		
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/TestData.xls");
			Workbook workbook= Workbook.getWorkbook(file);
			Sheet sheet= workbook.getSheet("RegisterData");
			value = sheet.getCell(col, row).getContents();
			

            workbook.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
		
		
	}
	
}
