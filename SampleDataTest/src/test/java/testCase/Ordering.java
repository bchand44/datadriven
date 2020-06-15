package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.TestBase;

public class Ordering extends TestBase{
	
	
@Test 

public void orderItems() throws InterruptedException
{
	click("signIn_xpath");
	type("existingEmail_xpath","bbb@bbb.com");
	type("password_id","bbbbb");
	click("login_xpath");
	Thread.sleep(3000);
	Assert.fail("Failing the Test");
	
	
}

}
