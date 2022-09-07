package API;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class dataDriven {
// declaring a object for workbook and sheet
	XSSFWorkbook work_book;
	XSSFSheet sheet;
	//initializing the function 
	@BeforeTest
	public  void ReadExcelFile() {
		try {
			File s = new File("src/test/java/API/datadriven.xlsx");
			FileInputStream stream = new FileInputStream(s);
			work_book = new XSSFWorkbook(stream);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test  (priority =1)
	public void getData() {
		int sheetnumber =0;
		int row =1;
		int column =1;
		sheet =work_book.getSheetAt(sheetnumber);
		// extracting data from the cell
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		
		System.out.println(data);
	}
}
