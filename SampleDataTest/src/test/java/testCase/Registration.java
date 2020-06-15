package testCase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;
import utilities.TestUtil;





public class Registration extends TestBase {

@Test(dataProviderClass=TestUtil.class,dataProvider="dp")

public void registerUser(Hashtable<String,String> data) throws InterruptedException
{
	System.out.println("Starting Registration");
	log.info("Registration Started");
	click("signIn_xpath");
	type("newEmail_xpath",data.get("emailAddress"));
	click("createAccount_name");
	
	//Thread.sleep(5000);
	//Assert.assertEquals(driver.findElement(By.xpath(or.getProperty("verifyRegistration_xpath"))).getText(),"CREATE AN ACCOUNT");
}



}
