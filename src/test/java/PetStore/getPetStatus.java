package PetStore;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import utility.Base;

public class getPetStatus extends Base{

	public getPetStatus() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public static void getStatus() throws IOException {
		// TODO Auto-generated method stub
		 getPetStatus gp = new getPetStatus();
		
		String response = given().spec(gp.requestsepc("getstatus")).queryParam("status", getstaus())
				.header("Content-Type","application/json")
		  .when().get("/pet/findByStatus")
		  .then().spec(gp.responsespec()).extract().response().asString();
		
		gp.getpetstatus(response);
		
		}
	
	//verify response contains our pet
	public void getpetstatus(String response) throws IOException {
		//check for particular pet we need
		  JsonPath jp = new JsonPath(response); 
		  int count=jp.getInt("id.size()");
		  boolean flag=false;
		  System.out.println("************************************************");
		  for(int i=0;i<count;i++) {
			  String petname = jp.getString("category["+i+"].name");
			  if(petname.equalsIgnoreCase(getname())) {
				  
				  flag=true;
				  break;
			  }   
		  }
		  if(flag) {
			  System.out.println("Oops...! Looks like Pet ur searching for is sold");
		  }else
			  System.out.println("Pet is not yet sold, may be available or pending verification");
		
	}

}
