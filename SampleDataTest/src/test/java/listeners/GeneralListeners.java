package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.TestUtil;

public class GeneralListeners  implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
