package DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;

import utility.ExcelReadWrite;


public class Commomdataprovider {
	ExcelReadWrite eRead = new ExcelReadWrite();
	
	
	@DataProvider(name="newpets")
	public Iterator<Object[]> petdetails(Method m) throws Exception {
		 String sheet = "addNewPet";//m.getName();
		 
      eRead.ExcelReadwrite(System.getProperty("user.dir")+"\\Resource\\Petdetails.xlsx");
    
      return commondpLogic(sheet);
	}
	
	@DataProvider(name="userdetails")
	public Iterator<Object[]> userdetails(Method m) throws Exception {
		 String sheet = m.getName();
		 
      eRead.ExcelReadwrite(System.getProperty("user.dir")+"\\Resource\\UserDetails.xlsx");
    
      return commondpLogic(sheet);
	}
	
	public Iterator<Object[]> commondpLogic(String sheet) {
		
		  int rowCount = eRead.rowCount(sheet);
	      int colCount = eRead.colCount(sheet);
	      
	      ArrayList<Object[]> ls = new ArrayList<Object[]>();	
			
//			iterate thru each row
			for(int iRow = 1 ;iRow<=rowCount;iRow++){
						
								
//				create object array
				Object[] obj = new Object[1];
				
//				create map
				Map<String, String> Map = new HashMap<String,String>();
//				iterate thru column
				for(int iCol = 0;iCol<colCount;iCol++){
					
					String Key = eRead.readCellValue(sheet, 0, iCol);
					String Val = eRead.readCellValue(sheet, iRow, iCol);
					
					Map.put(Key, Val);
					
				}	//			iterate thru column
				
				obj[0]=Map;
				ls.add(obj);
				}
				
			//		iterate thru each row
			
			
			return ls.iterator();
			
			
		}

}
