package webservice;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class POSTAPITest {
	
	@Test
	public void createTest(){
		
		Response resp= given().
		body("{ \"id\": 2, \"projectName\": \"test project number 2\", \"creationDate\": \"2017-03-14T18:16:38.703\", \"expiryDate\": \"2017-04-10T18:16:38.703\", \"enabled\": true,  \"targetCountries\": [\"USA\", \"CANADA\", \"MEXICO\", \"BRAZIL\"], \"projectCost\": 8.5, \"projectUrl\": \"http://www.unity3d.com\",  \"targetKeys\": [{  \"number\": 25,  \"keyword\": \"movie\" }, {  \"number\": 30,  \"keyword\": \"sports\"  }] } ").
		when().
		contentType(ContentType.JSON).
		post("http://localhost:8081/webservice/webapi/requestProject");
		
		System.out.println(resp.asString());
		
	}
}
