package userData;

import utility.Base;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

public class GetUser extends Base{

	public GetUser() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public static void getUser() throws IOException {
		// TODO Auto-generated method stub
		GetUser gu = new GetUser();
		given().spec(gu.requestsepc("GetUser"))
		.pathParam("username",username())
		.when().get("/user/{username}")
		.then().spec(gu.responsespec());
		
	}

}
