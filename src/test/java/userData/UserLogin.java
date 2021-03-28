package userData;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

import utility.Base;


public class UserLogin extends Base{
	
	
	public UserLogin() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public static void userLogin() throws IOException {
		// TODO Auto-generated method stub
		UserLogin ul = new UserLogin();
		given().spec(ul.requestsepc("UserLogin"))
		.queryParam("username", "ABC130")
		.queryParam("password", "ABC130")
		.when().get("/user/login")
		.then().spec(ul.responsespec());
	}

}
