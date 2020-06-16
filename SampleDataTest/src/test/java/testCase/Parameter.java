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
	
	
	  click("signIn_xpath");
		type("existingEmail_xpath",data.get("userName"));
		type("password_id",data.get("passWord"));
		click("login_xpath");
		Thread.sleep(3000);
		click("signOut_xpath");

			
			
		}



}
