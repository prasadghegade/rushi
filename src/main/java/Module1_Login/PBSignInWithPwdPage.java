package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBSignInWithPwdPage 
{
	@FindBy (xpath="//input[@type='password']") private WebElement pwd;
	@FindBy (xpath="//span[text()='Sign in']") private WebElement signin;
	
	public PBSignInWithPwdPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setPBSignInWithPwdPagePASSWORD (String PASSWORD) 
	{
		pwd.sendKeys(PASSWORD);
	}
	
	public void clickPBSignInWithPwdPageSIGNIN ()
	{
		signin.click();
	}
	
	
	
}
