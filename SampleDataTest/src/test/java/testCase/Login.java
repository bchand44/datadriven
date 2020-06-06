package testCase;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class Login extends TestBase {

@Test

public void loginUser() throws IOException, InterruptedException
{
	
	
	System.setProperty("org.uncommons.reportng.escape-output","false");
	System.out.println("Login Complete");
    log.info("Starting Login");
	Reporter.log("Login Completed");
	Reporter.log("<a target=\"_blank\" href=\"/Users/birendra/git/datadriven/SampleDataTest/test-output/html/a.png\">ScreenShot Caputured</a>");
	Reporter.log("<br>");
	Reporter.log("<a target=\"_blank\" href=\"/Users/birendra/git/datadriven/SampleDataTest/test-output/html/a.png\"><img src=\"/Users/birendra/git/datadriven/SampleDataTest/test-output/html/a.png\" height=200 width=200></img></a>");
	
	
}
}