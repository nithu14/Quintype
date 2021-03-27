package userData;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import utility.Base;

public class AddUser extends Base {

	public AddUser() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void addUser() {
		// TODO Auto-generated method stub
		ArrayList<Integer> id = new ArrayList<Integer>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> Fname = new ArrayList<String>();
		ArrayList<String> Lname = new ArrayList<String>();
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> pwd = new ArrayList<String>();
		ArrayList<String> phone = new ArrayList<String>();
		
		id.add(0);id.add(1);id.add(2);id.add(3);
		name.add("ABC");name.add("XYZ");name.add("DEF");name.add("MNO");
		Fname.add("Jim");Fname.add("Tom");Fname.add("Kim");Fname.add("don");
		Lname.add("john");Lname.add("won");Lname.add("fde");Lname.add("sri");
		email.add("abc@abc.com");email.add("xyz@abc.com");email.add("def@abc.com");email.add("mno@abc.com");
		pwd.add("123");pwd.add("456");pwd.add("789");pwd.add("852");
		phone.add("123456");phone.add("123456");phone.add("123456");phone.add("123456");
		
		for(int i=0;i<id.size();i++) {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		given().log().all().header("accept","application/json")
		.header("Content-Type","application/json")
		.body("[\r\n" + 
				"  {\r\n" + 
				"    \"id\": "+id.get(i)+",\r\n" + 
				"    \"username\": \""+name.get(i)+"\",\r\n" + 
				"    \"firstName\": \""+Fname.get(i)+"\",\r\n" + 
				"    \"lastName\": \""+Lname.get(i)+"\",\r\n" + 
				"    \"email\": \""+email.get(i)+"\",\r\n" + 
				"    \"password\": \""+pwd.get(i)+"\",\r\n" + 
				"    \"phone\": \""+phone.get(i)+"\",\r\n" + 
				"    \"userStatus\": 0\r\n" + 
				"  }\r\n" + 
				"]")
		.when().post("/user/createWithList")
		.then().log().all().assertThat().statusCode(200);
		
		}
		
	}

}
