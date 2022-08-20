package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBSignInWithMobNumPage 
{
	@FindBy (xpath="(//input[@type='number'])[2]") private WebElement mobno;
	@FindBy (xpath="(//span[@id='central-login-sign-in-with-password-span'])[2]") private WebElement signinwithpwd;
	
	
	public PBSignInWithMobNumPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setPBSignInWithMobNumPageMOBNO (String MOBNO) 
	{
		mobno.sendKeys(MOBNO);
	}
	
	
	public void clickPBSignInWithMobNumPageSIGNINWITHPWD() 
	{
		signinwithpwd.click();
	}
}
