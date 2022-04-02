package APIAutomation.ExtractKeyfromResponse;

import static io.restassured.RestAssured.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtractSingleKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Response getResponse =given().contentType(ContentType.JSON).when().get("http://localhost:3000/Staff");
		System.out.println("Response=>"+getResponse.asString());
		
		System.out.println("-----Extracting state from response--------");
		
		JSONArray js=new JSONArray(getResponse.asString());
		JSONObject ob= js.getJSONObject(0);
		JSONArray array=ob.getJSONArray("address");
		     JSONObject ob1=array.getJSONObject(1);
		     System.out.println(ob1.get("state"));
		     
		     //second way
		System.out.println(js.getJSONObject(0).getJSONArray("address").getJSONObject(1).get("state")); 

	}

}
