package amrutraibagi.DataDrivenFromExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderIntegrationWithExcel {
	
	DataFormatter formater=new DataFormatter();
	@Test(dataProvider="DriveExcel")
	public void testCaseData(String username, String password, String Email) {
		System.out.println(username+" "+password+" "+Email);
	}
	
	
	@DataProvider(name="DriveExcel")
	public Object[][] getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Documents\\ExcelIntegration.xlsx");
		XSSFWorkbook WB=new XSSFWorkbook(fis);
		XSSFSheet sheet=WB.getSheetAt(1);
		int rowCount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int cellCount=row.getLastCellNum();
		Object data[][]=new Object[rowCount-1][cellCount];
		//data[1][0]=amrut
		//data[1][1]=raibagi
		//data[1][2]=amrutraibagi2018@gmail.com
		
		for(int i=0;i<rowCount-1;i++) {
			row=sheet.getRow(i+1);
			for(int j=0;j<cellCount;j++) {
				XSSFCell cell=row.getCell(j);
				data[i][j]=formater.formatCellValue(cell);
			}
		}
		
		return data;
		
	}

}
