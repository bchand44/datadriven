package customlisteners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.TestUtil;

public class Listeners implements ITestListener {



public void onTestFailure(ITestResult arg0)
{
	System.setProperty("org.uncommons.reportng.escape-output","false");
	
	Reporter.log("Test is Complete");
	Reporter.log("<a href=TestUtil.screenshotName>Screen Shot</a>");
	//Reporter.log("<br>");
	
}





}
