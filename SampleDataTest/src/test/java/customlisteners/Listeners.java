package customlisteners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class Listeners extends TestBase implements ITestListener {




	public void onTestStart(ITestResult arg0)
	{
		test=reports.startTest(arg0.getName().toUpperCase());
		
		//setup run mode
		
	}
	
	
	
	
	public void onTestFailure(ITestResult arg0)
{
	System.setProperty("org.uncommons.reportng.escape-output","false");
	Reporter.log("Test Failed,refer to Screen Shot");
	//Reporter.log("<a target=\"_blank\" href=\"/Users/birendra/git/datadriven/SampleDataTest/test-output/html/a.png\">ScreenShot Caputured</a>");
	//Reporter.log("<br>");
	//Reporter.log("<a target=\"_blank\" href=\"/Users/birendra/git/datadriven/SampleDataTest/test-output/html/a.png\"><img src=\"/Users/birendra/git/datadriven/SampleDataTest/test-output/html/a.png\" height=200 width=200></img></a>");
	

try {
	TestUtil.captureScreenshot();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

test.log(LogStatus.FAIL,arg0.getName().toUpperCase()+"Test Failed :"+arg0.getThrowable());
test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName));

reports.endTest(test);
reports.flush();


Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">ScreenShot Caputured</a>");
Reporter.log("<br>");
Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");






}

public void onTestSkipped(ITestResult arg0)
{
	test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+"Skipped the test as Runmode is No");
	reports.endTest(test);
	reports.flush();
}
	
	
	
	
public void onTestSuccess(ITestResult arg0)

{
	
test.log(LogStatus.PASS,arg0.getName().toUpperCase()+"Pass");
reports.endTest(test);
reports.flush();



}







}
