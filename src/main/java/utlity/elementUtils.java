package utlity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementUtils 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public elementUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public By getBy(String locatorType, String locatorValue)
	{
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;	
		default:
			System.out.println("Please pass the correct locator "+locator);
			break;
		}
		return locator;
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	
	public void doSendKey(By locator, String value)
	{
		driver.findElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public String getText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public void waitForElementToPresent(By locator)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	}
	
}
