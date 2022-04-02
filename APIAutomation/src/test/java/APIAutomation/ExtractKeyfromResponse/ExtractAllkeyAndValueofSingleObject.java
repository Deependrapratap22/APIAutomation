package APIAutomation.ExtractKeyfromResponse;

import static io.restassured.RestAssured.*;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtractAllkeyAndValueofSingleObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Response getResponse =given().contentType(ContentType.JSON).when().get("http://localhost:3000/teacher");
		System.out.println("Response=>"+getResponse.asString());
		
		System.out.println("-----Extracting state from response--------");
		
		JSONArray jsonResposneArray=new JSONArray(getResponse.asString());
		//int lengtofArray=jsonResposneArray.length();
		           JSONObject obj= jsonResposneArray.getJSONObject(0);
		     Set<String> allkeys= obj.keySet();
		     for(String s : allkeys )
		     {
		    	 System.out.println("keys=>"+s +" Value=>"+obj.get(s) );
		    	 //System.out.println("Value=:"+obj.get(s));
		     }

	}

}
