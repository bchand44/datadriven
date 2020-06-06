package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.ExcelReader;
import utilities.ExtentManager;

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
	}
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
	


