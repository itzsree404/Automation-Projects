package core;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	public static String readData(int row, int col) {
		String value="";		
		try {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("ProductData");
            XSSFCell cell = sheet.getRow(row).getCell(col);
            if (cell.getCellType() == CellType.STRING) {
                value = cell.getStringCellValue();
            } else if (cell.getCellType() == CellType.NUMERIC) {
                value = String.valueOf(cell.getNumericCellValue());
            } else if (cell.getCellType() == CellType.BOOLEAN) {
                value = String.valueOf(cell.getBooleanCellValue());
            }
           // String username = ExcelData.readData(1, 0);
           // String password = ExcelData.readData(1, 1);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

}
