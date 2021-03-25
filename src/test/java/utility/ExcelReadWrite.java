package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReadWrite {
	FileInputStream fis;
	XSSFWorkbook wb;
	
	//Initialize Workbook
		public ExcelReadwrite(String Path) throws Exception{
			
//			Fileinput stream
			fis = new FileInputStream(Path);		
//			Workbook
			wb = new XSSFWorkbook(fis);
		}
		
//		get Row Count 
		public  int rowCount(String sheetName){
			
			XSSFSheet sheet = wb.getSheet(sheetName);		
			return sheet.getLastRowNum();			
			
		}
		
//		Get Column Count
		public  int colCount(String sheetName){
			
			XSSFSheet sheet = wb.getSheet(sheetName);		
			return sheet.getRow(0).getLastCellNum();			
			
		}
		
//		Write Cell Value
		public void writeCellValue(String sheetName,int row,int col,String Val){
			XSSFSheet sheet = wb.getSheet(sheetName);
			sheet.getRow(row).getCell(col).setCellValue(Val);
			
		}
		
//		Save and Close
		public void  saveAndClose(String Path) throws Exception{
//			fileoutput Stream
			FileOutputStream fos = new FileOutputStream(Path);
			
//			Save
			wb.write(fos);
			
//			Close stream
			fis.close();
			fos.close();
			
			
			
		}

}
