package APIAutomation.PojoClassExample;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ComplexArrayJsonPostRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ComplexJsonaddress1info[] address=new ComplexJsonaddress1info[2];
		
		//setting array for array object
		address[0]=new ComplexJsonaddress1info();
		address[0].setCity("New Delhi");
		address[0].setState("Delhi");
		
		address[1]=new ComplexJsonaddress1info();
		address[1].setCity("jaunpur");
		address[1].setState("Uttar Pradesh");
		
		ComplexArrayJsonBasicInfo jsonBody=new ComplexArrayJsonBasicInfo();
		jsonBody.setFirstName("Deependra");
		jsonBody.setLastName("Singh");
		jsonBody.setId("6");
		jsonBody.setAddress(address);
		

		Response postResponse=given().contentType(ContentType.JSON).body(jsonBody).when().post("http://localhost:3000/teacher");
		System.out.println("Response Code=>"+postResponse.getStatusCode());
		
		Response getResponse =given().contentType(ContentType.JSON).when().get("http://localhost:3000/teacher");
		System.out.println("Response=>"+getResponse.asString());
		
		
	}

}
