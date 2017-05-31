package webservice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class GETAPITest {

	/* Test script when no parameters are passed */
	@Test
	public void test1(){
		
		Response response = when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.asString());
	}
	
	/* Test script when only project id is passed */
	@Test
	public void test2(){
		
		Response response = given().
				param("projectid","2").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when only country is passed */
	@Test
	public void test3(){
		
		Response response = given().
				param("country","USA").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when only number is passed */
	@Test
	public void test4(){
		
		Response response = given().
				param("number","12").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when only keyword is passed */
	@Test
	public void test5(){
		
		Response response = given().
				param("keyword","sports").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when project id and country are passed */
	@Test
	public void test6(){
		
		Response response = given().
				param("projectid","2").
				param("country","USA").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when project id and number are passed */
	@Test
	public void test7(){
		
		Response response = given().
				param("projectid","2").
				param("number","12").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when project id and keyword are passed */
	@Test
	public void test8(){
		
		Response response = given().
				param("projectid","2").
				param("keyword","sports").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when country and number are passed */
	@Test
	public void test9(){
		
		Response response = given().
				param("country","USA").
				param("number","12").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when country and keyword are passed */
	@Test
	public void test10(){
		
		Response response = given().
				param("country","USA").
				param("keyword","sports").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when number and keyword are passed */
	@Test
	public void test11(){
		
		Response response = given().
				param("number","12").
				param("keyword","sports").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when projectid, country and number are passed */
	@Test
	public void test12(){
		
		Response response = given().
				param("projectid","2").
				param("country","USA").
				param("number","12").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when projectid, country and keyword are passed */
	@Test
	public void test13(){
		
		Response response = given().
				param("projectid","2").
				param("country","USA").
				param("keyword","sports").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when projectid, number and keyword are passed */
	@Test
	public void test14(){
		
		Response response = given().
				param("projectid","2").
				param("number","12").
				param("keyword","sports").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when country, number and keyword are passed */
	@Test
	public void test15(){
		
		Response response = given().
				param("country","USA").
				param("number","12").
				param("keyword","sports").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/* Test script when all four parameters are passed */
	@Test
	public void test16(){
		
		Response response = given().
				param("projectid","2").
				param("country","USA").
				param("number","12").
				param("keyword","sports").
				when().
				get("http://localhost:8081/webservice/webapi/requestProject");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
