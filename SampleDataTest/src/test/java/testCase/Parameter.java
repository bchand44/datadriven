package testCase;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class Parameter extends TestBase {

@Test(dataProviderClass=TestUtil.class,dataProvider="dp")

		public void parameter(Hashtable<String,String> data) throws IOException, InterruptedException
		{
			
	if(!(TestUtil.isTestRunnable("parameter", excel))){
		
		throw new SkipException("Skipping the test "+"parameter".toUpperCase()+ "as the Run mode is NO");
	}
	
	// using thread for now as the test fails if running via Jenkins, need to implement dynamic waits    
	
	
	    Thread.sleep(5000);
	    click("signIn_xpath");
	    Thread.sleep(2000);
		type("existingEmail_xpath",data.get("userName"));
		Thread.sleep(2000);
		type("password_id",data.get("passWord"));
		Thread.sleep(2000);
		click("login_xpath");
		Thread.sleep(15000);
		softAssertion("Sign out",getText("signOut_xpath"));
		getText("signOut_xpath");
		Thread.sleep(9000);
		click("signOut_xpath");
		Thread.sleep(3000);

			
			
		}



}
