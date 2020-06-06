package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
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

	
	
}
