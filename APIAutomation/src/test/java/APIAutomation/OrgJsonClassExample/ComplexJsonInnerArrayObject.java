package APIAutomation.OrgJsonClassExample;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ComplexJsonInnerArrayObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating json body with the help of jsonobject and jsonarray object through org.json
		
		JSONObject primaryaddress=new JSONObject();
		primaryaddress.put("HouseNo", "65");
		primaryaddress.put("Area", "Sultanpur");
		primaryaddress.put("city", "Delhi");
		primaryaddress.put("Landmark", "Sharma Store");
		primaryaddress.put("Pincode", "110030");
		
		JSONObject secondryaddress=new JSONObject();
		secondryaddress.put("HouseNo", "202");
		secondryaddress.put("Area", "kanuwani");
		secondryaddress.put("city", "jaunpur");
		secondryaddress.put("Landmark", "pertol pump");
		secondryaddress.put("Pincode", "222146");
		
		JSONArray arrayobject=new JSONArray();
		arrayobject.put(0, primaryaddress);
		arrayobject.put(1, secondryaddress);
		
		JSONObject outerBody=new JSONObject();
		outerBody.put("firstname", "Anuj");
		outerBody.put("lastnname", "Verma");
		outerBody.put("company", "sapient");
		outerBody.put("id", "3");
		outerBody.put("Address", arrayobject);
		
		
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
//output
   {
      "firstname": "Anuj",
      "lastnname": "Verma",
      "Address": [
        {
          "HouseNo": "65",
          "Area": "Sultanpur",
          "city": "Delhi",
          "Landmark": "Sharma Store",
          "AddressType": "Primary Address",
          "Pincode": "110030"
        },
        {
          "HouseNo": "202",
          "Area": "kanuwani",
          "city": "jaunpur",
          "Landmark": "petrol pump",
          "AddressType": "Secondry Address",
          "Pincode": "222146"
        }
      ],
      "company": "sapient",
      "id": "3"
    }


*/