package testCase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class Login extends TestBase {

@Test(dataProviderClass=TestUtil.class,dataProvider="dp")

public void login(Hashtable<String,String> data) throws IOException, InterruptedException
{
if(!(TestUtil.isTestRunnable("login", excel))){
		
		throw new SkipException("Skipping the test "+"login".toUpperCase()+ "as the Run mode is NO");
	}	

click("signIn_xpath");
type("existingEmail_xpath",data.get("userName"));
type("password_id",data.get("passWord"));
click("login_xpath");
Thread.sleep(3000);
click("signOut_xpath");

	
	
}
}