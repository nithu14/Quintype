package PetStore;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.time.StopWatch;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utility.Base;

public class getPetStatus extends Base{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		RestAssured.baseURI = Baseurl;
		String response = given().queryParam("status", "sold").log().all()
		  .header("accept", "application/json")
		  .when().get("/pet/findByStatus")
		  .then().log().all().assertThat().statusCode(200).extract().response().asString();
		stopWatch.stop();
		long time = stopWatch.getTime();
		System.out.println("Time is "+time);
		
		
		  JsonPath jp = new JsonPath(response); 
		  int count=jp.getInt("id.size()");
		  System.out.println("************************************************");
		  System.out.println(count);
		  for(int i=0;i<count;i++) {
		   System.out.println(jp.getString("id["+i+"]"));
		  }
		 
		 

	}

}
