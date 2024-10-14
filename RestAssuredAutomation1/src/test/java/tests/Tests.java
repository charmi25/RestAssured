package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Tests {

	 @Test(description = "Verify that the Get Post API returns correctly")
	 public void verifyGetAPI() {

	  // Given
	  given()
	    .baseUri("https://jsonplaceholder.typicode.com")
	             .header("Content-Type", "application/json")

	  // When
	  .when()
	    .get("/posts/1")

	  // Then
	  .then()
	    .statusCode(200)
	    // To verify correct value
	    .body("userId", equalTo(1))
	    .body("id", equalTo(1))
	    .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
	    .body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
	 }

}
