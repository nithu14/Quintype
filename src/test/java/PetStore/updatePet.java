package PetStore;

import io.restassured.path.json.JsonPath;
import utility.Base;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import DataProvider.Commomdataprovider;

public class updatePet extends Base {
	static String newstatus;
	static String ID ;

	public updatePet() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(dataProvider="newpets",dataProviderClass = Commomdataprovider.class)
	public static void updatePetdetails(Map<String,String> hm) throws IOException {
		// TODO Auto-generated method stub
		String name = hm.get("Name");
		 ID = hm.get("ID");
		updatePet up = new updatePet();
		newstatus=Upstatus();
		
			
		for(int i=0;i<hm.size();i++) {
			if(name.equalsIgnoreCase(getname())) {
		// update the status
				 given().log().all().spec(up.requestsepc("updatePet"))
				.header("Content-Type","application/x-www-form-urlencoded")
				.formParams("name", name)
				.formParam("status", newstatus)
				.when().post("/pet/"+ID)
				.then().log().all();
				 up.getresponse();
				break;
		
			}
		}
		
		 
		
	}
	
	//check for id updated in db
	public void getresponse() throws IOException {
		updatePet up = new updatePet();
		String response = given().spec(up.requestsepc("getstatus")).queryParam("status", newstatus)
				  .when().get("/pet/findByStatus")
				  .then().spec(up.responsespec()).extract().response().asString();
		
		JsonPath jp = new JsonPath(response); 
		int count=jp.getInt("id.size()");
		 
		  System.out.println("************************************************");
		  for(int i=0;i<count;i++) {
			  String requiredID = jp.get("id["+i+"]").toString();
			  if(ID.equalsIgnoreCase(requiredID)) {
				  String status = jp.getString("status["+i+"]");
				  if(status.equalsIgnoreCase(newstatus)) {
					  System.out.println("Pet status updated ");
				  }
			  }
		  }
	}

}
