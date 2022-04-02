package APIAutomation.PojoClassExample;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimpleJsonpojoclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleJsonBasicInfo jsonBody=new SimpleJsonBasicInfo();
		jsonBody.setFirstName("Desh Deepak");
		jsonBody.setLastName("Viskarma");
		jsonBody.setId("10");
		
		
	Response response=	given().contentType(ContentType.JSON).body(jsonBody)
		.when().post("http://localhost:3000/teacher");
	
	System.out.println("Response code=>"+response.getStatusCode());

	Response response1=	given().contentType(ContentType.JSON)
			.when().get("http://localhost:3000/teacher");
	
	System.out.println("Response=>"+response1.asString());
	
	}

}
