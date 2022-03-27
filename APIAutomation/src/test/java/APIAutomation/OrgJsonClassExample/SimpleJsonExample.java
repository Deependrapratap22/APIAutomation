package APIAutomation.OrgJsonClassExample;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class SimpleJsonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	   JSONObject bodyData=new JSONObject();
	   bodyData.put("Firstname", "Rahul");
	   bodyData.put("LastName", "Pauchari");
	   bodyData.put("company", "TCS");
	   bodyData.put("id", "4");

	   Response postResponse=given()
	   .contentType(ContentType.JSON)
	   .body(bodyData.toString())
	   .when()
	   .post("http://localhost:3000/teacher");
	   
	   System.out.println("Post Response Code=>"+postResponse.getStatusCode());
	   
	   
	   Response getResponse=
			   given().contentType(ContentType.JSON)
			   .when()
			   .get("http://localhost:3000/teacher");
	   
	   System.out.println("Get Response Code"+getResponse.getStatusCode());
	   System.out.println("Response"+getResponse.asString());
	   
	   
	   
	}

}


/*

"firstname": "Deependra",
"company": "abc",
"id": "1",
"age": "36",
"lastname": "Singh"

*/