package restassuredwithoutBDD;
//DUMMY API FROM : https://reqres.in/
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	
	@Test
	public void testGet() {
		System.out.println(" ============= GET Call ====================");
		
		baseURI = "https://reqres.in/api";
		
		given().
		    get("/users?page=2")

		.then()
		    .statusCode(200)
		    .body("data[4].first_name", equalTo("George")) // checks at location
		    .body("data.first_name", hasItems("George","Rachel")); // checks list
		   // error if we pass wrong list to be checked  eg passed Georges instead of George
//		java.lang.AssertionError: 1 expectation failed.
//		JSON path data.first_name doesn't match.
//		Expected: (a collection containing "Georges" and a collection containing "Rachel")
//		  Actual: <[Michael, Lindsay, Tobias, Byron, George, Rachel]>
	}
	
	
	@Test
	public void testPostReqBodyWithMap() {
		System.out.println(" ============= Form Post Request body using Map ====================");

		Map <String , Object> map = new HashMap<String, Object>();
		map.put("name", "Charmi");
		map.put("job", "Manager");
		
		System.out.println(map);  //{name=Charmi, job=Manager}
 //Its in string format and we need it in Json format so we need to use Jackson library . Using JSON.simple
	
	JSONObject postreqbody= new JSONObject(map);
	System.out.println(postreqbody); //{"name":"Charmi","job":"Manager"}

	System.out.println(postreqbody.toJSONString()); //{"name":"Charmi","job":"Manager"}
	}
	
	@Test
	public void testPostReqBodyWithoutMAP() {
		
		System.out.println(" ============= Form Post Request body using JSONObject ====================");

		// if we use jsonObject then we do not need map to put the key value pair , can use JSONObject
		
		JSONObject postreqbody= new JSONObject();

		postreqbody.put("name", "jsonobject");
		postreqbody.put("Job", "QA");
		 
		postreqbody.put("name", "jsonobject1");
		postreqbody.put("Job", "QA1");
		
		
		System.out.println(postreqbody);
		
		
		
//		//
//		{"name":"Charmi","job":"Manager"}
//		{"name":"jsonobject1","Job":"QA1"}
		
	}

	
	@Test
	public void testpostcall() {
		System.out.println(" ============= POST CALL ====================");

		JSONObject postreqbody= new JSONObject();

		postreqbody.put("name", "jsonobject");
		postreqbody.put("Job", "QA");
		
		
baseURI = "https://reqres.in/api";
		
		
		given()
		//.body(postreqbody)  //java.lang.IllegalArgumentException: Cannot serialize because no JSON or XML serializer found in classpath.

		// so req body needs to be converted to toJosnstring as below
		.body(postreqbody.toJSONString())
		.when()
		.post("/users")
		.then()
		  .statusCode(201)
		 .log().all();
	}
	
	public void testpostwithheaderscall() {
		System.out.println(" ============= Adding Headers==================");
		baseURI = "https://reqres.in/api";
		JSONObject postreqbody= new JSONObject();

		postreqbody.put("name", "jsonobject");
		postreqbody.put("Job", "QA");
		
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(postreqbody.toJSONString())
		.when()
		.post("/users")
		.then()
		  .statusCode(201);
	}
}
