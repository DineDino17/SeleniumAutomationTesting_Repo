package testNGBasics;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataUtilsJavaClass {
	
	//If indices = 0 then data on index 0 will be taken to run and other won't run
	//If indices = {2, 3} then data on index 2 and 3 will be taken to run and other won't run
	//If we don't use indices then everything will run
	//If parallel = true then test will run in parallel based on no of data
	
	// We can also have without name attribute @DataProvider(indices = {0}, parallel = false)
	//In this case we need to use method name in @Test for the attribute dataProvider = "getData"
	
	//@DataProvider(name = "UserCreds", indices = {0}, parallel = false)
	public String[][] getData() {
		String [][] credentials = new String[3][2];
		
		//Index - 0
		credentials[0][0] = "Admin";
		credentials[0][1] = "admin123";
		
		//Index - 1
		credentials[1][0] = "TestAdmin";
		credentials[1][1] = "Test@1234";
		
		//Index - 2
		credentials[2][0] = "WrongUser";
		credentials[2][1] = "WrongPass";
		
		return credentials;
		
	}
	
	@DataProvider(name = "UserCreds", parallel = false)
	public String[][] getDataFromExcelDynamic() throws IOException {
		String excelFileLocation = "./test-data/Test Data 1.xlsx";
		XSSFWorkbook srcExcelFile = new XSSFWorkbook(excelFileLocation);
		int rowSize = srcExcelFile.getSheetAt(0).getLastRowNum();
		int columnSize = srcExcelFile.getSheetAt(0).getRow(0).getLastCellNum();
		String [][] dataFromExcel = new String[rowSize][columnSize];
		
		for(int i=1; i<=rowSize; i++) {
			XSSFRow rowValue = srcExcelFile.getSheetAt(0).getRow(i);
				for(int j=0; j<columnSize ;j++) {
					XSSFCell cellValue = rowValue.getCell(j);
					DataFormatter formatData = new DataFormatter();
					String value = formatData.formatCellValue(cellValue);
					dataFromExcel[i-1][j] = value;
				}
		}
		srcExcelFile.close();
		return dataFromExcel;
	}

}
