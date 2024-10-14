package restassuredwithoutBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDelete {
	
	@Test
	public void testput() {

		System.out.println("===================== PUT CALL ===============");
		JSONObject postreqbody= new JSONObject();

		postreqbody.put("name", "jsonobject");
		postreqbody.put("Job", "updated");
		
		
baseURI = "https://reqres.in/api";
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(postreqbody.toJSONString())
		.when()
		.put("/users/2")
		.then()
		  .statusCode(200)
		  .log().all();
		
		
//	O/P 	since headers are added
		//{
//		    "name": "jsonobject",
//		    "Job": "updated",
//		    "updatedAt": "2024-10-11T09:30:05.392Z"
//		}
}
	
	
	@Test
	public void testpatch() {

		System.out.println("===================== PATCH CALL ===============");
		JSONObject postreqbody= new JSONObject();

		postreqbody.put("name", "jsonobject");
		postreqbody.put("Job", "updated");
			
baseURI = "https://reqres.in/api";
		
		given()
//		.header("Content-Type","application/json")
//		.contentType(ContentType.JSON)
//		.accept(ContentType.JSON)
		.body(postreqbody.toJSONString())
		.when()
		.patch("/users/2")
		.then()
		  .statusCode(200)
		  .log().all();
		
//	O/P since headers is commented o/p is as below 
		//{
//		    "updatedAt": "2024-10-11T09:30:04.708Z"
//		}
}
	
	@Test
	public void testDelete() {
		System.out.println("===================== DELETE CALL ===============");

		
baseURI = "https://reqres.in/api";

		when()
		.delete("/users/2")
		.then()
		  .statusCode(204)
		  .log().all();
		
	}
}
