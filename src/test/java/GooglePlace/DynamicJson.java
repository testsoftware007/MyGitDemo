package GooglePlace;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resource.Payload;
import Resource.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class DynamicJson {
	JsonPath js;

	@Test(dataProvider = "getData")
	public void addBook(String isbn, String aisle) throws IOException {
		/*
		 * RestAssured.baseURI = "https://rahulshettyacademy.com"; String respone =
		 * given().log().all().header("Content-Type",
		 * "application/json").body(Payload.addBook(isbn, aisle)).when()
		 * .post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).
		 * extract().asString();
		 * 
		 * js = ReusableMethods.rawToJson(respone); String id = js.getString("ID");
		 * System.out.println(id);
		 */
		ReusableMethods.excelDataReader();

	}
	 
	
	@DataProvider
	public Object getData()
	{
		Object ar= new Object[][]{{"Deepak", "2"}, {"Deeepak", "4"}};
		return ar;
	}

}
