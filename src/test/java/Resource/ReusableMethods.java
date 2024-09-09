package Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath rawToJson(String s) {
		JsonPath js = new JsonPath(s);
		return js;
	}
	
	public static void excelDataReader() throws IOException
	{
		FileInputStream fis  = new FileInputStream("C:\\Users\\dsain\\Desktop\\Learning\\MyExcel.xlsx");
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		XSSFSheet sheet = xs.getSheet("Hello");
		System.out.println(sheet.getRow(0).getCell(1));
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getLastRowNum());
	}

}
