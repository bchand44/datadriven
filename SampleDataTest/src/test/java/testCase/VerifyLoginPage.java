package testCase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class VerifyLoginPage extends TestBase{


@Test

public void verifyLoginPage() throws InterruptedException
{
	click("signIn_xpath");
	
	Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("verifySignIn_xpath"))),"Sign in not found");
}


}
