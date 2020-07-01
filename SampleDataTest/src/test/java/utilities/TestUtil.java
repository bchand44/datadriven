package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.TestBase;



public class TestUtil extends TestBase{

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		System.out.println(screenshotName);
		FileUtils.copyFile(scrFile,
				new File("/Users/birendra/git/datadriven/SampleDataTest/target/surefire-reports/html/"+screenshotName));

	System.out.println("Screen Shot Captured");
	
	}
	
	public static String randomEmail()
	{
		String rndEmail=RandomStringUtils.randomAlphabetic(4).toLowerCase()+"@test.com";
	    return rndEmail;
	}	

	

public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
	
	
	
	@DataProvider(name="dp") 

	public Object[][] getData(Method m)
	{
		
		String sheetName=m.getName();// getting name of the method
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
		
	
	
	@DataProvider(name="d") 

	public Object[][] setData(Method m)
	{
		
		String sheetName=m.getName();// getting name of the method
		System.out.println("Sheet Name is:"+ sheetName);
		int rows = excel.getRowCount(sheetName);
		System.out.println("Number of Rows:"+rows);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put("firstName",excel.setData(sheetName,"userName", rowNum,randomEmail()));
				data[rowNum - 2][0] = table;
			}

		}

		return data;
	
	}
	
	
	
	
}
