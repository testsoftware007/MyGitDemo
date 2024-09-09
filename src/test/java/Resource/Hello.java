package Resource;

import java.util.Set;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;

import io.restassured.response.Response;

public class Hello {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("");
		String text= driver.swtichTo().alert().getText();
		driver.swtichTo().alert().dismiss();
		
     List<WebElement> elements =  driver.findElements(By.xpath(""));
     
     for(WebElement e: elements)
     {
    	 if(e.getText().equalsIngnoreCase("India"))
    	 {
    		 e.click();
    		 break;
    	 }
     }
     
    Set<String> windows = driver.getWindowHandles();
    Iterator i = windows.iterator();
    String parent = i.next();
    String child = i.next();
    driver.swtichTo.window(child);
    String text= driver.findElement(By.xpath("")).getText();
    
    Response res=
    		
    	when().then().assertThat().
    	String name= res.jsonPath().getString("name");
    
    
    
    
    
		// TODO Auto"-generated method stub

	}

}
