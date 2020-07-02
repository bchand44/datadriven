package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.TestUtil;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties or=new Properties();
	public static Properties config=new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("Adding Log");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"//src//test//resources//excel//testdata.xlsx");
    public ExtentReports reports=ExtentManager.getInstance();
    public static ExtentTest test;
    public static WebDriverWait wait;
	
	
	
	@BeforeSuite
	
	public void startDriver() throws IOException
	{
		if(driver==null)
		{
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		fis=new FileInputStream(System.getProperty("user.dir")+"//src//test///resources//properties//config");
		config.load(fis);
	    log.info("Config File is loaded");
	    fis=new FileInputStream(System.getProperty("user.dir")+"//src//test///resources//properties//or");
	    or.load(fis);
	    log.info("OR File is loaded");
		if(config.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//exe//chromedriver");
			driver= new ChromeDriver();
		}
		else if(config.getProperty("browser").equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
		}
	    
	    
	    driver.get(config.getProperty("testurl"));
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		
	}
	}
	
	
	public String getText(String locator)
	{
		if(locator.endsWith("xpath"))
		{
			
			
			test.log(LogStatus.INFO,"Text Extracted   :"+locator);
		}
		return driver.findElement(By.xpath(or.getProperty(locator))).getText();
		
	}
	
	
	
	public void click(String locator) throws InterruptedException
	{
		

		
		if(locator.endsWith("xpath"))
		{
			
			driver.findElement(By.xpath(or.getProperty(locator))).click();
			test.log(LogStatus.INFO,"Click on   :"+locator);
			log.info("clicking locator :"+locator);
		}
		else if(locator.endsWith("_id"))
		{
			driver.findElement(By.id(or.getProperty(locator))).click();
			test.log(LogStatus.INFO,"Click on   :"+locator);
			log.info("clicking locator :"+locator);
		}
		
		else if(locator.endsWith("_name"))
		{
			driver.findElement(By.name(or.getProperty(locator))).click();
			test.log(LogStatus.INFO,"Click on   :"+locator);
			log.info("clicking locator :"+locator);
		}
		else if(locator.endsWith("_css"))
		{
			driver.findElement(By.cssSelector(or.getProperty(locator))).click();
			test.log(LogStatus.INFO,"Click on   :"+locator);
			log.info("clicking locator :"+locator);
		}
		
	}
	
	public void type(String locator,String value)
	{
		
		if(locator.endsWith("xpath"))
		{
			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
			test.log(LogStatus.INFO,"Typing on  :"+locator+"entering value:  "+value);
			log.info("Value Pass is :"+value);
		}
		else if(locator.endsWith("_id"))
		{
			driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
			test.log(LogStatus.INFO,"Typing on  :"+locator+"entering value:  "+value);
			log.info("Value Pass is :"+value);
		}
		
		else if(locator.endsWith("_name"))
		{
			driver.findElement(By.name(or.getProperty(locator))).sendKeys(value);
			test.log(LogStatus.INFO,"Typing on  :"+locator+"entering value:  "+value);
			log.info("Value Pass is :"+value);
		
		}
		else if(locator.endsWith("_css"))
		{
			driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
			test.log(LogStatus.INFO,"Typing on  :"+locator+"entering value:  "+value);
			log.info("Value Pass is :"+value);
		}
		
	
	}
	
	
	public static void softAssertion(String expected,String actual) throws IOException
	{
		try 
		{ 
			Assert.assertEquals(expected,actual);
			
		} catch(Throwable t)
		{
			TestUtil.captureScreenshot();
			
			//ReportNG Reports 
			
			Reporter.log("<br>"+"Soft Assertion failed, moving on with Test"+t.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
		    Reporter.log("<br>");
		    Reporter.log("<br>");
		  
			//Extend Reports
		    
		    test.log(LogStatus.FAIL,"Soft Verififcation Failed,moving on with Test"+t.getMessage());
		    test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName));
		
		
		}
	}
	
	
	public void elementwait(WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver,40);
		
		wait.until(ExpectedConditions.visibilityOf(locator));

	}
	
	
	
	public boolean isElementPresent(By by)
	{
		try {
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e)
		{
	return false;
		}
	
	}
	
	
	
	
	
	
	
	@AfterSuite
	
	public void endDriver()
	{
		if (driver != null) {
			driver.quit();
		}

	log.info("driver is closed");
	}
	}
	


