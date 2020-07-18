package Tests;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class RequestVerification {
	
	//Verification of Get Method
		@Test
		public void VerifyGetRequest() {
		given().queryParam("foo1", "bar1").queryParam("foo2", "bar2")
		.when().get("https://postman-echo.com/get")
		.then().log().all().assertThat().statusCode(200).header("Content-Type", "application/json; charset=utf-8")
		.header("Connection", "keep-alive");
		}
		
	//Verification of Post Raw Text Method
		@Test
		public void verifyPostRawText()
		{
			given().body("This is expected to be sent back as part of response body.")
			.when().post("https://postman-echo.com/post")
			.then().assertThat().statusCode(200).body("data", equalTo("This is expected to be sent back as part of response body."))
			.header("Content-Type", "application/json; charset=utf-8");
		}

		
	//Verification of Put Request Method
		@Test
		public void verifyPutRequest()
		{
			given().body("This is expected to be sent back as part of response body.")
			.when().put("https://postman-echo.com/put")
			.then().assertThat().statusCode(200).body("data", equalTo("This is expected to be sent back as part of response body."))
			.header("Content-Type", "application/json; charset=utf-8");
		}
		
		//Verification of Patch Request Method
		@Test
		public void verifyPatchRequest()
		{
			given().body("This is expected to be sent back as part of response body.")
			.when().put("https://postman-echo.com/patch")
			.then().assertThat().statusCode(404);
		}		
		
		//Verification of Delete Request Method
		@Test
		public void verifyDeleteRequest()
		{
			given().body("This is expected to be sent back as part of response body.")
			.when().put("https://postman-echo.com/delete")
			.then().assertThat().statusCode(404);
		}

}
