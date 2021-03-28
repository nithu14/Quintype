package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import com.sun.org.apache.bcel.internal.classfile.Method;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Base {
//	public static String Baseurl;
	public static Properties pro;
	public static FileInputStream fis;
	public static ExtentReports report;
	
	public Base() throws IOException {
		pro = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"\\Resource\\gobol.properties");
		pro.load(fis);
	}

	
	public static String getBaseURI() throws IOException {
		// TODO Auto-generated method stub
		
	return pro.getProperty("BaseURL");
	}
	
	public static String getstaus() throws IOException {
		// TODO Auto-generated method stub
	return pro.getProperty("getstatus");
	}
	
	public static String getname() throws IOException {
		// TODO Auto-generated method stub
	return pro.getProperty("petname");
	}
	
	public static String Upstatus() throws IOException {
		// TODO Auto-generated method stub
	return pro.getProperty("updatestatus");
	}
	
	public static String photoID() throws IOException {
		// TODO Auto-generated method stub
	return pro.getProperty("PetID_photoUpload");
	}
	public static String username() throws IOException {
		// TODO Auto-generated method stub
	return pro.getProperty("username");
	}
	public static String photoURL() throws IOException {
		// TODO Auto-generated method stub
	return System.getProperty("user.dir")+pro.getProperty("Photo_URL");
	}
	
	
	public RequestSpecification requestsepc(String name) throws IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");  
		   LocalDateTime now = LocalDateTime.now();  
		    
		  
		PrintStream log=new PrintStream(new FileOutputStream(System.getProperty("user.dir")+"\\logs\\"+name+"_"+dtf.format(now)+"_logging_.txt"));
		 RequestSpecification req = new RequestSpecBuilder()
	    .setBaseUri(getBaseURI())
	    .addFilter(RequestLoggingFilter.logRequestTo(log))
	    .addFilter(ResponseLoggingFilter.logResponseTo(log))
	    .addHeader("accept", "application/json")
	    .build();
		 
		 return req;
	    
	}
	
	public ResponseSpecification responsespec() {
		ResponseSpecification res = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(200)
				.build();
	return res;
	}
	
	public static ExtentReports Extendreport() {
		report=new ExtentReports(System.getProperty("user.dir") +"/report/testReport.html");
		report
        .addSystemInfo("Host Name", "Interviewcode")
        .addSystemInfo("User Name", "Nithanth");
		
		return report;
	}

}
