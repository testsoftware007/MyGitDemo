package GooglePlace;

import org.testng.Assert;

import Resource.Payload;
import Resource.ReusableMethods;
import io.restassured.path.json.JsonPath;

public class ComplexJsonResponse {
	
	static int myprice = 0;
	public static void main(String aa[])
	{
	
	JsonPath js = new JsonPath(Payload.complexJson());
	
	//Get the count of courses
	int count = js.getInt("courses.size()");
	System.out.println(count);
	
	//Get the Purchaseamount
	int purchaseamount = js.getInt("dashboard.purchaseAmount");
	System.out.println(purchaseamount);
	
	//Get the first coursetitle
	String coursetitle= js.getString("courses[0].title");
	System.out.println(coursetitle);
	for(int i=0; i<count; i++)
	{
		//Get the title and price of each course
		String titile = js.getString("courses["+i+"].title");
		int price = js.getInt("courses["+i+"].price");
		System.out.println("Title of "+i+" course = "+titile);
		System.out.println("Price of "+i+" course = "+price);
		
		//Get the price of RPA course
		if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
		{
			int rpaprice = js.getInt("courses["+i+"].price");
			System.out.println("RPA price is = "+rpaprice);
		}
		
		//Get the Sum of all Course prices
		myprice = myprice+price*js.getInt("courses["+i+"].copies");
		
		
	}
	
	Assert.assertEquals(myprice, purchaseamount);
	if(myprice==purchaseamount)
		System.out.println("Price Matches");
	
	
	
	
	
	
	
	}

}
