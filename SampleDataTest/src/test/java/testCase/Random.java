package testCase;

import org.testng.annotations.Test;

import utilities.TestUtil;

public class Random {


@Test(dataProviderClass=TestUtil.class,dataProvider="d")
public void random()
{
	System.out.println();
}


}
