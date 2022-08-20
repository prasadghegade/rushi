package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.PBLoginPage;
import Module1_Login.PBMyProfilePage;
import Module1_Login.PBProfilePage;
import Module1_Login.PBSignInWithMobNumPage;
import Module1_Login.PBSignInWithPwdPage;

public class PBLoginTest extends BaseClass
{	
	
	PBLoginPage login;
	PBSignInWithMobNumPage mobno;
	PBSignInWithPwdPage pwd;
	PBMyProfilePage profile;
	PBProfilePage page;
	int TCID;
	
	
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException 
	{
		initializeBrowser();
		
		
		login = new PBLoginPage(driver);
		mobno = new PBSignInWithMobNumPage(driver);
		pwd = new PBSignInWithPwdPage(driver);
		profile = new PBMyProfilePage(driver);
		page = new PBProfilePage(driver);
	}
	
	@BeforeMethod
	public void LoginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.clickPBLoginPageSIGNIN();
		mobno.setPBSignInWithMobNumPageMOBNO(UtilityClass.getPFdata("MobNum"));
		mobno.clickPBSignInWithMobNumPageSIGNINWITHPWD();
		pwd.setPBSignInWithPwdPagePASSWORD(UtilityClass.getPFdata("PWD"));
		pwd.clickPBSignInWithPwdPageSIGNIN();
		Thread.sleep(3000);
		
	}
	
	@Test
	public void VerifyPN() throws EncryptedDocumentException, IOException 
	{
		TCID=101;
		login.mouseovverPBLoginPageMYACC();
		profile.clickPBMyProfilePageMYPROFILE();
		page.SwitchToChildWindow();
		//page.VerifyPBProfilePagePROFILENAME(sh.getRow(0).getCell(2).getStringCellValue());
		
		String actPN = page.getPBProfilepageProfileName();
		String expPN = UtilityClass.getID(0, 2);
		Assert.assertEquals(actPN, expPN, "failed: both results are not same");
	}
	
	@AfterMethod
	public void LogoutfromApp(ITestResult result) throws IOException
	{
		if (result.getStatus()==result.FAILURE) 
		{
			UtilityClass.captureScreenShot(driver, TCID);
		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
