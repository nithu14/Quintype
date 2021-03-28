package utility;

import java.lang.reflect.Array;

import org.testng.annotations.DataProvider;

public class rawJson {

	public static String addPost(String Name,String Status,String ID) {
		return "{\r\n" + 
				"  \"id\": "+ID+",\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \""+Name+"\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \""+Name+"\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \"string\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 0,\r\n" + 
				"      \"name\": \"string\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \""+Status+"\"\r\n" + 
				"}";
	}
	
	public static String adduser(String id,String name,String Fname,String Lname,String email,String pwd,String phone) {
		
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"id\": "+id+",\r\n"
				+ "    \"username\": \""+name+"\",\r\n"
				+ "    \"firstName\": \""+Fname+"\",\r\n"
				+ "    \"lastName\": \""+Lname+"\",\r\n"
				+ "    \"email\": \""+email+"\",\r\n"
				+ "    \"password\": \""+pwd+"\",\r\n"
				+ "    \"phone\": \""+phone+"\",\r\n"
				+ "    \"userStatus\": 0\r\n"
				+ "  }\r\n"
				+ "]";
		
	}
	
}
