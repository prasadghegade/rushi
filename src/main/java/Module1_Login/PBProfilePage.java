package Module1_Login;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBProfilePage
{
	@FindBy (xpath="//div[text()='PrasadGhegade']") private WebElement ProfileName;
	
	WebDriver driver1;
	
	public PBProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void SwitchToChildWindow()
	{
		Set<String> allids = driver1.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(allids);
		driver1.switchTo().window(ar.get(1));
 	}
	
	
	public String getPBProfilepageProfileName()
	{
		String actPN = ProfileName.getText();
		return actPN;
	}
	
	
//	public void VerifyPBProfilePagePROFILENAME(String expPN)
//	{
//		String actPN = ProfileName.getText();
//		
//		if(actPN.equals(expPN)) 
//		{
//			System.out.println("Pass");
//		}
//		else 
//		{
//			System.out.println("Fail");
//		}
//	}
}
