package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utlity.excelUtility;

public class loginTest extends baseTest
{
	@Test(dataProvider="loadData")
	public void doLogin(String username, String password)
	{
		lPage.doLogin(username, password);
	}
	
	@DataProvider
	public Object[][] loadData()
	{
		return excelUtility.getData("Sheet1");
	}

}
