package test;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public  class Util {

	//public static final String FILE_PATH = "data.xlsx";
	public static final String SHEET_NAME = "Sheet1"; 
	public static final int WAIT_TIME = 30;
	public static final String BASE_URL = "http://www.demo.guru99.com/v4/";
	public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
	public static final String EXPECT_ERROR = "User or Password is not valid";

	// Valid account for login
	public static final String USER_NAME = "mngr476324";
	public static final String PASSWD = "supYsYb";
	
	

	public static String[][] getXLData(String xlSheetName) throws IOException 
	{
     
		File file = new File(System.getProperty("user.dir") + "\\excel\\data.xlsx");

		FileInputStream fis = new FileInputStream(file);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sheetName = wb.getSheet(xlSheetName);

		int totalRows = sheetName.getLastRowNum();

		//System.out.println(totalRows);

		Row rowCells = sheetName.getRow(0);

		int totalCols = rowCells.getLastCellNum();

		//System.out.println(totalCols);
		
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalRows][totalCols];
		
		for(int i = 1; i <= totalRows; i++)  {
			
			for(int j = 0; j < totalCols; j++) {
				
			    testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
			    
			   // System.out.println(testData[i-1][j]);
			}
		}

             return testData;
	}	 

}
