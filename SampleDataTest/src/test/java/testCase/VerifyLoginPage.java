package testCase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class VerifyLoginPage extends TestBase{


@Test

public void verifyLoginPage() throws InterruptedException, IOException
{
	
if(!(TestUtil.isTestRunnable("verifyLoginPage", excel))){
		
		throw new SkipException("Skipping the test "+"verifyLoginPage".toUpperCase()+ "as the Run mode is NO");
	}
	
	
	softAssertion("abc","dac");
	click("signIn_xpath");
    Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("verifySignIn_xpath"))),"Sign in not found");
}


}
