package userData;

import utility.Base;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

public class DeleteUser extends Base{

	public DeleteUser() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@Test
	public static void deleteUser() throws IOException {
		// TODO Auto-generated method stub
		DeleteUser du = new DeleteUser();
		given().spec(du.requestsepc("GetUser"))
		.pathParam("username",username())
		.when().get("/user/{username}")
		.then().spec(du.responsespec());
	}

}
