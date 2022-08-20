package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLoginPage 
{
	@FindBy (xpath="//a[text()='Sign in']") private WebElement signin;
	@FindBy (xpath="//div[@class='userprofile']") private WebElement MyAcc;
	
	WebDriver driver1;
	
	public PBLoginPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void clickPBLoginPageSIGNIN()
	{
		signin.click();
	}
	
	public void mouseovverPBLoginPageMYACC()
	{
		Actions act = new Actions(driver1) ;
		act.moveToElement(MyAcc).perform();
		
	}
	
}
