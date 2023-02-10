package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utlity.Constants;
import utlity.elementUtils;

public class loginPage 
{
	public WebDriver driver;
	public elementUtils eU;
	private By login_Xpath = By.xpath("//*[@id='modalusername']");
	private By pass_Xpath = By.xpath("//*[@id='current-password']");
	private By loginBtn_Xpath = By.xpath("//*[@id='root']/div/div/div[4]/div[1]/div/div[4]/div[1]/button");
	private By homeTitle_Xpath = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/h2");
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
		eU= new elementUtils(driver);
	}
	
	public void doLogin(String username, String password)
	{
		eU.doSendKey(login_Xpath, username);
		eU.doSendKey(pass_Xpath, password);
		eU.doClick(loginBtn_Xpath);
		eU.waitForElementToPresent(homeTitle_Xpath);
		String actualTitle = eU.getText(homeTitle_Xpath);
		Assert.assertEquals(actualTitle, Constants.home_page_Title);
	}
	
	
	

}
