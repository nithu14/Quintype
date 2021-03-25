package utility;

import java.lang.reflect.Array;

import org.testng.annotations.DataProvider;

public class rawJson {

	public static String addPost(String Name,String Status) {
		return "{\r\n" + 
				"  \"id\": 0,\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \""+Name+"\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \"doggie\",\r\n" + 
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
	
}
