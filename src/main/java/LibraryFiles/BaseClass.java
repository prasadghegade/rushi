package LibraryFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	public WebDriver driver;
	public void initializeBrowser() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ghega\\eclipse-workspace\\26March_Maven2\\Browser_Files\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPFdata("URL"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
}
