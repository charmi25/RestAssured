package restassuredwithoutBDD;
import java.io.*;

import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import  io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Getmethod {

	//adding @Test makes its testNg test and then you will be able to run as testNG test
	@Test
	public void getmethod() {
		
		// need to write restAssured.get if import is not static import 
		//Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		
		//if we go for static import of restassured then we can write direct get() instead of RestAssured.get()
		
		Response response= get("https://reqres.in/api/users?page=2");
		
		System.out.println("Response :: "+ response.asString());
		System.out.println("Response :: "+ response.getBody().asString());
		System.out.println("Response status code :: "+ response.getStatusCode());
		
		
		
		//O/P :
//		Response :: {"page":2,"per_page":6,"total":12,"total_pages":2,"data":[{"id":7,"email":"michael.lawson@reqres.in","first_name":"Michael","last_name":"Lawson","avatar":"https://reqres.in/img/faces/7-image.jpg"},{"id":8,"email":"lindsay.ferguson@reqres.in","first_name":"Lindsay","last_name":"Ferguson","avatar":"https://reqres.in/img/faces/8-image.jpg"},{"id":9,"email":"tobias.funke@reqres.in","first_name":"Tobias","last_name":"Funke","avatar":"https://reqres.in/img/faces/9-image.jpg"},{"id":10,"email":"byron.fields@reqres.in","first_name":"Byron","last_name":"Fields","avatar":"https://reqres.in/img/faces/10-image.jpg"},{"id":11,"email":"george.edwards@reqres.in","first_name":"George","last_name":"Edwards","avatar":"https://reqres.in/img/faces/11-image.jpg"},{"id":12,"email":"rachel.howell@reqres.in","first_name":"Rachel","last_name":"Howell","avatar":"https://reqres.in/img/faces/12-image.jpg"}],"support":{"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}
//		Response :: {"page":2,"per_page":6,"total":12,"total_pages":2,"data":[{"id":7,"email":"michael.lawson@reqres.in","first_name":"Michael","last_name":"Lawson","avatar":"https://reqres.in/img/faces/7-image.jpg"},{"id":8,"email":"lindsay.ferguson@reqres.in","first_name":"Lindsay","last_name":"Ferguson","avatar":"https://reqres.in/img/faces/8-image.jpg"},{"id":9,"email":"tobias.funke@reqres.in","first_name":"Tobias","last_name":"Funke","avatar":"https://reqres.in/img/faces/9-image.jpg"},{"id":10,"email":"byron.fields@reqres.in","first_name":"Byron","last_name":"Fields","avatar":"https://reqres.in/img/faces/10-image.jpg"},{"id":11,"email":"george.edwards@reqres.in","first_name":"George","last_name":"Edwards","avatar":"https://reqres.in/img/faces/11-image.jpg"},{"id":12,"email":"rachel.howell@reqres.in","first_name":"Rachel","last_name":"Howell","avatar":"https://reqres.in/img/faces/12-image.jpg"}],"support":{"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}
//		Response status code :: 200
	
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		//Assert.assertEquals(response.getStatusCode(), 201);
		//java.lang.AssertionError: expected [201] but found [200]

	}
	
	

	
	@Test
	public void test_2()
	{
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2")
		.then().statusCode(200)
		.body("data[1].id",equalTo(8))  //for equalTo we haveimported hamcrestmatchers
		.log()
		.all();  // log.all is used to print the logs
		
	}
}
