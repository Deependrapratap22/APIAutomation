package APIAutomation.OrgJsonClassExample;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class ComplexJsonInnerJsonObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating the Json Body with help of org.json
		
		JSONObject innerBody=new JSONObject();
		innerBody.put("HouseNo", "65");
		innerBody.put("Area", "Sultanpur");
		innerBody.put("city", "Delhi");
		innerBody.put("Landmark", "Sharma Store");
		innerBody.put("Pincode", "110030");
		
		JSONObject outerBody=new JSONObject();
		outerBody.put("firstname", "Priyanka");
		outerBody.put("lastnname", "Singh");
		outerBody.put("company", "sapient");
		outerBody.put("id", "1");
		outerBody.put("Address", innerBody);
		
	//Hitting post request
		Response postresponse =
				
				given().contentType(ContentType.JSON)
				.body(outerBody.toString())
				.when()
				.post("http://localhost:3000/teacher");

	
	System.out.println("Post response code=>"+postresponse.getStatusCode());
	
	
	//Hitting the Get Request
	
	Response getresponse=given().contentType(ContentType.JSON).when().get("http://localhost:3000/teacher");
	System.out.println("Get Response Status Code==>"+getresponse.getStatusCode());
	System.out.println("Response==>"+getresponse.asString());
	
	}

}
/*
//out put json
{
    "firstname": "Priyanka",
    "lastnname": "Singh",
    "Address": {
      "HouseNo": "65",
      "Area": "Sultanpur",
      "city": "Delhi",
      "Landmark": "Sharma Store",
      "Pincode": "110030"
    },
    "company": "sapient",
    "id": "1"
  }

*/