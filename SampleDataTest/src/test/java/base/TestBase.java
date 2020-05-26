package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties or=new Properties();
	public static Properties config=new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	
	
	@BeforeSuite
	
	public void startDriver() throws IOException
	{
		if(driver==null)
		{
		
		fis=new FileInputStream(System.getProperty("user.dir")+"//src//test///resources//properties//config");
		config.load(fis);
	    log.debug("config file loaded");
	    fis=new FileInputStream(System.getProperty("user.dir")+"//src//test///resources//properties//or");
	    or.load(fis);
	    log.debug("or file loaded");
		if(config.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//exe//chromedriver");
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
	@AfterSuite
	
	public void endDriver()
	{
		if (driver != null) {
			driver.quit();
		}

		log.debug("test execution completed !!!");
	}
	}
	


