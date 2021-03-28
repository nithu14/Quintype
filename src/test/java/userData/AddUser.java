package userData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;

import DataProvider.Commomdataprovider;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import utility.Base;
import utility.rawJson;

public class AddUser extends Base {

	public AddUser() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider="userdetails",dataProviderClass = Commomdataprovider.class)
	public static void addUser(Map<String,String> hm) throws IOException {
		// TODO Auto-generated method stub
		 String id = hm.get("Id");
		String name = hm.get("Uname");
		String Fname = hm.get("Lname");
		String Lname = hm.get("Lname");
        String email = hm.get("email");
         String pwd = hm.get("password");
	    String phone = hm.get("phone");
	    AddUser au = new AddUser();
	  
		
		for(int i=0;i<hm.size();i++) {
		
		given().spec(au.requestsepc("addUser"))
		.header("Content-Type","application/json")
		.body(rawJson.adduser(id, name, Fname, Lname, email, pwd, phone))
		.when().post("/user/createWithList")
		.then().spec(au.responsespec());
		
		}
		
	}

}
