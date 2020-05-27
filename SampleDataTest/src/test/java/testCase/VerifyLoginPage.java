package testCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;

public class VerifyLoginPage extends TestBase{


@Test

public void verifyLoginPage()
{
	driver.findElement(By.xpath(or.getProperty("clickSignIn"))).click();
	Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("vrifySignIn"))),"Sign in not found");
	Reporter.log("Login Assertion Complete");
}


}
