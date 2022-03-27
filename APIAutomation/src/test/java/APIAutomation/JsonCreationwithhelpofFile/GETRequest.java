package APIAutomation.JsonCreationwithhelpofFile;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GETRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Response res=given().contentType(ContentType.JSON)
				.when()
				.get("http://localhost:3000/Student");

				System.out.println("Status Code=>"+res.statusCode());
				System.out.println("Response=:"+res.asString());
				
				System.out.println("------------------------------------------------------------");
				Response resId=given().contentType(ContentType.JSON)
				.when()
				.get("http://localhost:3000/Student/2");

				System.out.println("Status Code=>"+resId.statusCode());
				System.out.println("Response=:"+resId.asString());
				
				
				System.out.println("------------------------------------------------------------");
				Response resqueryparam=given().contentType(ContentType.JSON)
				.when()
				.get("http://localhost:3000/Student?firstname=Deependra");

				System.out.println("Status Code=>"+resqueryparam.statusCode());
				System.out.println("Response=:"+resqueryparam.asString());
	}

}
