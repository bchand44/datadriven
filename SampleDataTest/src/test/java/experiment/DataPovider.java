package experiment;

import java.util.Hashtable;

import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class DataPovider extends TestBase {


@Test(dataProviderClass=TestUtil.class,dataProvider="d")

public void random(Hashtable<String,String> data) throws InterruptedException
{
	
	String email=data.get("emailAddress");
	 click("signIn_xpath");
	 Thread.sleep(3000);
	 type("newEmail_xpath",email); 
}


}
