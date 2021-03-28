package userData;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import utility.Base;

public class UserLogOut extends Base{

	public UserLogOut() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public static void userLogout() throws IOException {
		// TODO Auto-generated method stub

		UserLogOut ul = new UserLogOut();
		given().spec(ul.requestsepc("UserLogOut"))
		.when().get("/user/logout")
		.then().spec(ul.responsespec());
	}

	
}
