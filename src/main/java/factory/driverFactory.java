package factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utlity.Constants;

public class driverFactory 
{
	public Properties prop;
	public WebDriver driver;
	public optionManager om;
	private static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();
	
	public WebDriver init_browser(Properties prop)
	{
		//prop = new Properties();
		om = new optionManager(prop);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver(om.chromeOptions()));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver(om.firefoxOptions()));
		} 
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tl.set(new EdgeDriver(om.edgeOptions()));
		}
		else
		{
			System.out.println("Please pass the correct browser" +browserName);
		}
		
		getDriver().get(prop.getProperty("login_url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}
	
	public synchronized static WebDriver getDriver()
	{
		return tl.get();
	}
	
	public Properties init_prop()
	{
		FileInputStream fs = null;
		prop = new Properties();
		
		try {
			fs = new FileInputStream(Constants.config_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	

}
