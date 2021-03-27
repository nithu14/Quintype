package PetStore;

import io.restassured.RestAssured;
import utility.Base;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

public class UpdatePhoto extends Base{

	public UpdatePhoto() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public static void uploadPhoto() throws IOException {
		// TODO Auto-generated method stub
		UpdatePhoto up = new UpdatePhoto();
		given().spec(up.requestsepc("UpdatePhoto"))
		.pathParam("petId",photoID())
		.header("Content-Type","multipart/form-data")
		.formParam("additionalMetadata", "uploading photo")
		.multiPart("file",new File(photoURL()))
		.when().post("/pet/{petId}/uploadImage")
		.then().spec(up.responsespec());
		
	}

}
