package testCase;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class Ordering extends TestBase{
	
	
@Test 

public void ordering() throws InterruptedException
{
	
if(!(TestUtil.isTestRunnable("ordering", excel))){
		
		throw new SkipException("Skipping the test "+"ordering".toUpperCase()+ "as the Run mode is NO");
	}
	
	click("signIn_xpath");
	type("existingEmail_xpath","bbb@bbb.com");
	type("password_id","bbbbb");
	click("login_xpath");
	Thread.sleep(3000);
	
	
	
}

}
