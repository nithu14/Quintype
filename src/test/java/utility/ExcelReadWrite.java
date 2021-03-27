package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import groovyjarjarasm.asm.commons.Method;


public class ExcelReadWrite {
	static FileInputStream fis;
	static XSSFWorkbook wb;
	ExcelReadWrite ew;
	//Initialize Workbook
		public void ExcelReadwrite(String Path) throws Exception{
			
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
		
		public String readCellValue(String sheetName,int row,int col){
			XSSFSheet sheet = wb.getSheet(sheetName);
			XSSFCell cell = sheet.getRow(row).getCell(col);
			String celltext = null;
			
			if(cell.getCellType()==CellType.STRING){
				celltext = cell.getStringCellValue();
			}else if(cell.getCellType()==CellType.NUMERIC){
				celltext = String.valueOf(cell.getNumericCellValue());			
			}else if(cell.getCellType()==CellType.BLANK){
				celltext = "";			
			}
		
			return celltext;	
			
		}
		
//		Write Cell Value
		public void writeCellValue(String name,String Val,String cname,String SheetN) throws IOException{
			//Fileinput stream
						/*
			 * fis = new FileInputStream(System.getProperty("user.dir")+path); // Workbook
			 * wb = new XSSFWorkbook(fis);
			 */
			XSSFSheet sheet = wb.getSheet(SheetN);
			ew=new ExcelReadWrite();
			int row = ew.rowCount(SheetN);
			Iterator<Row> rt = sheet.rowIterator();
				int k = 0,column=0;
				Row Frow = rt.next();
				Iterator<Cell> ct = Frow.cellIterator();
				while(ct.hasNext()) {
					Cell next = ct.next();
					if(next.getStringCellValue().equalsIgnoreCase(cname)) {
						column=k;
						break;
					}
					k++;
			}
			
		
				for(int i=0;i<row;i++) {
					if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(name)) {
						sheet.getRow(i).getCell(column).setCellValue(Val);	
						break;
					}
				}
				
			
				
			
			
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
