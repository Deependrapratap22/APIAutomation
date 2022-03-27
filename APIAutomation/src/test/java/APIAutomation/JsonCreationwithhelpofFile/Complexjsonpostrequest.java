package APIAutomation.JsonCreationwithhelpofFile;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Complexjsonpostrequest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file=new File("../APIAutomation/JsonRequest/ComplexJson.json");
        FileReader fr=new FileReader(file);
        JSONTokener jt=new JSONTokener(fr);
        JSONObject body=new JSONObject(jt);
        
        Response res=given()
        .contentType(ContentType.JSON)
        .body(body.toString())
        .when()
        .post("http://localhost:3000/Student");
        
        System.out.println("Response Code=>"+res.getStatusCode());
	}

}
