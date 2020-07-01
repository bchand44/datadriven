package experiment;

import java.util.Hashtable;

import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class DataPovider extends TestBase {


@Test(dataProviderClass=TestUtil.class,dataProvider="d")

public void random(Hashtable<String,String> data)
{
	System.out.println(data.get("firstName"));
}


}
