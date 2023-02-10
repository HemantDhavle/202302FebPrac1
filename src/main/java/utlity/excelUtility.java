package utlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtility 
{
	public static FileInputStream fs;
	public static Workbook book;
	public static Sheet sheet;
	//public static final String path = "";
	
	
	public static Object[][] getData(String sheetName)
	{
		Object[][] data = null;
		try {
			fs = new FileInputStream(Constants.data_path);
			book = WorkbookFactory.create(fs);
			sheet = book.getSheet(sheetName);
		} catch (IOException | InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		data = new Object[rows][cols];
		for(int i =0 ;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	
	
//	
//	public static void main (String args[])
//	{
//		Object[][] loadData= getData("Sheet1");
//		int rows = loadData.length;
//		int cols = loadData[0].length;
//		
//		for(int i =0;i<rows;i++)
//		{
//			for(int j=0;j<cols;j++)
//			{
//				System.out.println(loadData[i][j]);
//			}
//		}
//	}
}
