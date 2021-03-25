package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
	public static String Baseurl=null;
	public static Properties pro;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties pro = new Properties();

	System.out.println();
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Resource\\base.property");
	pro.load(fis);;
	Baseurl=pro.getProperty("BaseURL");
	}

}
