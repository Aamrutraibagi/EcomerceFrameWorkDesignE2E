package amrutraibagi.DataDrivenFromExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class dataDriven {
	
	public ArrayList<String> getData(String sheetName,String rowName) throws IOException {
		
		ArrayList<String> arr=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\Documents\\DataDrivenSrc.xlsx");
		//FileInputStream argument
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//If workbook has many sheet check the sheet
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				//Get access to all rows of sheet
				//Identify "Testcase" column by scanning the entire 1st row
				Iterator<Row> rows=sheet.iterator();  // Sheet is collection of Rows
				Row firstRow=rows.next();
				Iterator<Cell> cells=firstRow.cellIterator(); // Row is collection of cells
				
				int k=0;
				int column=0;
				while(cells.hasNext()){
					Cell value=cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
					{
						//inside Desired column
						column=k;
					}
					k++;
				}
				//System.out.println(column);
				
				//once column is identified then scan entire testcase column to identify "purchase" row
				while(rows.hasNext()) {
					Row row=rows.next();
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase(rowName))
					{
						
						//after you grab purchase row pull all the data of that row and feed into the test case
						Iterator<Cell> cellsInRequiredRow=row.cellIterator(); // Row is collection of cells
						
						while(cellsInRequiredRow.hasNext()){
							Cell value=cellsInRequiredRow.next();
							switch(value.getCellType()) {
							case STRING:
								arr.add(value.getStringCellValue());
								break;
							case NUMERIC:
								
								arr.add(NumberToTextConverter.toText(value.getNumericCellValue()));
								break;
							}
							
							
						}
						
					}
					
				}
				
				
			}
			
		}
		return arr;
		

	}

	public static void main(String[] args) throws IOException {
		
		

	}
}