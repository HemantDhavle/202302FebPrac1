package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import factory.driverFactory;
import pages.loginPage;

public class baseTest 
{
	public WebDriver driver;
	public Properties prop;
	public driverFactory factory;
	public loginPage lPage;
	
	@BeforeTest
	public void setUp()
	{
		factory = new driverFactory();
		prop = factory.init_prop();
		driver = factory.init_browser(prop);
		lPage = new loginPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
