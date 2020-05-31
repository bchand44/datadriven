package testCase;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;

public class Registration extends TestBase {

@Test(dataProvider="getData")

public void registerUser(Hashtable<String,String> data)
{
	System.out.println("Starting Registration");
	log.info("Registration Started");
	driver.findElement(By.xpath(or.getProperty("clickSignIn"))).click();
	driver.findElement(By.id(or.getProperty("emailAddress"))).sendKeys(data.get("emailAddress"));
	driver.findElement(By.name(or.getProperty("createAccount"))).click();
}

@DataProvider 

public Object[][] getData()
{
	
	String sheetName="Registration";
	int rows = excel.getRowCount(sheetName);
	int cols = excel.getColumnCount(sheetName);

	Object[][] data = new Object[rows - 1][1];
	
	Hashtable<String,String> table = null;

	for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

		table = new Hashtable<String,String>();
		
		for (int colNum = 0; colNum < cols; colNum++) {

			// data[0][0]
			table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
			data[rowNum - 2][0] = table;
		}

	}

	return data;
}

}
