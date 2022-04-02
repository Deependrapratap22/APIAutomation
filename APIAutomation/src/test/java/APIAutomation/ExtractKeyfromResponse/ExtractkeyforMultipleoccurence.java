package APIAutomation.ExtractKeyfromResponse;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtractkeyforMultipleoccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Response getResponse =given().contentType(ContentType.JSON).when().get("http://localhost:3000/teacher");
		System.out.println("Response=>"+getResponse.asString());
		
		System.out.println("-----Extracting state from response--------");
		
		JSONArray jsonResposneArray=new JSONArray(getResponse.asString());
		//int lengtofArray=jsonResposneArray.length();
		
		for (int i=0;i<jsonResposneArray.length();i++)
		{
		    JSONObject jo=	jsonResposneArray.getJSONObject(i);
		    System.out.println(jo.get("id"));
		    
		    //or we use below code in single line
		   try{
		    System.out.println(jsonResposneArray.getJSONObject(i).get("firstname"));
		   }
		   catch(JSONException e)
		   {
			   System.out.println(e);
		   }
		}

	}

}
