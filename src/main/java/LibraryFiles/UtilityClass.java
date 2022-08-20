package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{	
	
	// @AuthorName Prasad
	//This method is use to get TestData from excel sheet
	//need to pass 2 inputs ie. 1. rowIndex, 2. colIndex
	public static String getID(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\ghega\\eclipse-workspace\\26March_Maven2\\TestData\\March26_Eve.xlsx");		
		Sheet sh = WorkbookFactory.create(file).getSheet("PB_DDF");
		
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	//@AuthorName: Prasad
	//This method is use to capture screenshot of webpage
	//need to pass 2 inputs:  1.webdriver object, 2. int TCID
	public static void captureScreenShot(WebDriver driver, int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\ghega\\eclipse-workspace\\26March_Maven2\\Screenshot\\TestCaseID"+TCID+ ".jpg");
		FileHandler.copy(src, dest);
	}
	
	
	public static String getPFdata(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\ghega\\eclipse-workspace\\26March_Maven2\\Propertyfile.properties");
	
		Properties p = new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		return value;
		
	}
	
}
