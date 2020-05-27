package testCase;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.TestBase;

public class Login extends TestBase {

@Test

public void loginUser()
{
	
	System.setProperty("org.uncommons.reportng.escape-output","false");
	System.out.println("Login Complete");
	log.debug("login done");
	Reporter.log("Login complete");
	Reporter.log("<a href=\"/Users/birendra/git/datadriven/SampleDataTest/src/test/resources/properties/a.png\">Screenshot</a>");
}
	
	
}
