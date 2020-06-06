package testCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
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
	
log.info("Starting login Page");
driver.findElement(By.xpath(or.getProperty("signIn"))).click();
driver.findElement(By.xpath(or.getProperty("provideEmail"))).sendKeys("abc@aaa.com");
	
	
}
}