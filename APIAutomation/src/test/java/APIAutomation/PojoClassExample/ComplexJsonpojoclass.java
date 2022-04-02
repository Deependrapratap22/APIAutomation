package APIAutomation.PojoClassExample;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ComplexJsonpojoclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ComplexJsonaddress1info address1=new ComplexJsonaddress1info();
		address1.setCity("jaunpur");
		address1.setState("UP");
		
		ComplexJsonBasicInfo jsonBody=new ComplexJsonBasicInfo();
		jsonBody.setFirstName("Suneet");
		jsonBody.setLastName("Pandey");
		jsonBody.setId("5");
		jsonBody.setAddress(address1);

	Response postResponse=
			given().contentType(ContentType.JSON).body(jsonBody).when().post("http://localhost:3000/teacher");
	
	System.out.println("Response=>"+postResponse.getStatusCode());
	
	Response getResponse=
			given().contentType(ContentType.JSON).when().get("http://localhost:3000/teacher");
	
	System.out.println("Response=>"+getResponse.asString());
	}

}
