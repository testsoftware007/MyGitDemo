package GooglePlace;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Resource.Payload;
import Resource.ReusableMethods;

public class AddPlace {
	
	static JsonPath js;

	public static void main(String[] args) {

		String address = "Noida Extension";

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.jsonbody(address)).when().post("/maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract()
				.asString();

		 js = ReusableMethods.rawToJson(response);
		String place_id = js.getString("place_id");
		System.out.println("Place_id is = " + place_id);

		// Get Place
		String res = given().log().all().queryParam("place_id", place_id).queryParam("key", "qaclick123").when()
				.get("maps/api/place/get/json").then().log().all().extract().asString();
		js = ReusableMethods.rawToJson(res);
		String actual_address = js.getString("address");
		Assert.assertEquals(actual_address, address);

		// Validate the address in the response is correct

		// Delete Place
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").when()
				.body(Payload.deletePlace(place_id)).delete("maps/api/place/delete/json").then().log().all();

		// TODO Auto-generated method stub

	}

}
