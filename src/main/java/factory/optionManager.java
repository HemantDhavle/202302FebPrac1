package factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class optionManager 
{
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	public optionManager(Properties prop)
	{
		this.prop = prop;
	}

	public ChromeOptions chromeOptions()
	{
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		return co;
	}
	public FirefoxOptions firefoxOptions()
	{
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		return fo;
	}
	
	public EdgeOptions edgeOptions()
	{
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) eo.addArguments("--incognito");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) eo.addArguments("--headless");
		return eo;
	}
	
	
}
