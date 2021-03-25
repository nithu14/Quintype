package PetStore;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utility.Base;
import utility.rawJson;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddNewPet extends Base{

	@Test(dataProvider="petinsert",dataProviderClass = PetStore.AddNewPet.class)
	public static void addNewPet(String name,String Status) {
		ArrayList<String> al=new ArrayList<String>();
		// TODO Auto-generated method stub\
		// https://rahulshettyacademy.com/maps/api/place/add/json?key=
		long start = System.currentTimeMillis();
		RestAssured.baseURI = Baseurl;
		String response = given().log().all().header("Content-Type", "application/json")
		  .header("accept", "application/json") .body(rawJson.addPost(name,Status)) .when().post("/pet")
		  .then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		long end = System.currentTimeMillis();
		long rtime=start-end;
		System.out.println("response time is "+rtime);
		  JsonPath jp = new JsonPath(response); 
		  al.add(jp.getString("id"));
		  System.out.println("**************************************************");
		  System.out.println("id is "+al);
		  System.out.println("***************************************************");
		 
		 
	}
	@DataProvider(name="petinsert")
	public String[][] getdata() {
		String a[][]= new String[3][2];
		a[0][0]="Tom";
		a[0][1]="pending";
		a[1][0]="gym";
		a[1][1]="available";
		a[2][0]="julie";
		a[2][1]="sold";
		return a;
	}

}
