package APIAutomation.JsonCreationwithhelpofFile;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimpleJsonthroughFile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file=new File("../APIAutomation/JsonRequest/SimpleJson.json");
		FileReader fr= new FileReader(file);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject jsonBody=new JSONObject(jt);
		System.out.println(jsonBody);
		
		Response res= given()
		.contentType(ContentType.JSON)
		.body(jsonBody.toString())
		.when()
		.post("http://localhost:3000/Student");
		
       System.out.println("Response=>"+res.getStatusCode());

	}

}
