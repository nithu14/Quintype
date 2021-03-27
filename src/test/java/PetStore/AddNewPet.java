package PetStore;

import io.restassured.path.json.JsonPath;
import utility.Base;
import utility.ExcelReadWrite;
import utility.rawJson;
import DataProvider.Commomdataprovider;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AddNewPet extends Base{
		
	public AddNewPet() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Test(dataProvider="newpets",dataProviderClass = Commomdataprovider.class)
	public static void addNewPet(Map<String,String> hm) throws Exception {
		String name = hm.get("Name");
		String Status = hm.get("Status");
		String ID = hm.get("ID");
		
		 AddNewPet ap =new AddNewPet();
		 //starting stopwatch
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
			//request builder
		String response = given().log().all().spec(ap.requestsepc("addNewPet"))
				.header("Content-Type","application/json")
		.body(rawJson.addPost(name,Status,ID)) .when().post("/pet")
		  .then().spec(ap.responsespec()).extract().response().asString();
		
		stopWatch.stop();
		
		
		
		// calculates response time in seconds 
		System.out.println("Response time is "+stopWatch.getTime(TimeUnit.SECONDS));
		  JsonPath jp = new JsonPath(response); 
		    String id = jp.getString("id");
				 
		    ExcelReadWrite ex  = new ExcelReadWrite();

		    //writes id in excel for future reference
		ex.writeCellValue(name, id,"ID","addNewPet");
		  
		 
	}
	
	
	  @AfterTest 
	  public void teardown() throws Exception { 
		  ExcelReadWrite ex= new ExcelReadWrite();
	  ex.saveAndClose(System.getProperty("user.dir")+"\\Resource\\Petdetails.xlsx");
	  
	  }
	 
	 
	
	

}
