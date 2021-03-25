package PetStore;

import io.restassured.RestAssured;
import utility.Base;

import static io.restassured.RestAssured.*;

public class updatePet extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		given().log().all()
		.pathParam("petId", "9222968140497532000")
		.header("accept", "application/json")
		.header("Content-Type","application/x-www-form-urlencoded")
		.header("name","ABC")
		.header("status","sold")
		.when().post("/pet")
		.then().log().all().assertThat().statusCode(200);
		
	}

}
