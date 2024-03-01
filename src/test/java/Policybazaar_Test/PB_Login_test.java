package Policybazaar_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFile.BaseClass;
import LibraryFile.Utilityclass;
import Policybazaar.PBHomePage;
import Policybazaar.PBLogINPage;
import Policybazaar.PBMobNumPage;
import Policybazaar.PBMyAccPage;
import Policybazaar.PBMyProfilePage;
import Policybazaar.PBPwdPage;

public class PB_Login_test extends BaseClass
{

	int a;              //declare_globally
	PBLogINPage login;
	PBMobNumPage monum;
	PBPwdPage pwd;
	PBHomePage homepage;
	PBMyAccPage myacc;
	PBMyProfilePage myprofile;
	int TCID;
	//WebDriver driver;
	
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException {
		
		
	    initializeBrowser();  
	    //driver=new ChromeDriver();
		//driver.get("https://www.policybazaar.com/");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 TCID=102;
		 login=new PBLogINPage(driver);
		 monum=new PBMobNumPage(driver);
		 pwd=new PBPwdPage(driver);
		 homepage=new PBHomePage(driver);
		 myacc=new PBMyAccPage(driver);
		 myprofile=new PBMyProfilePage(driver);
		a=10; //initialize_localy
	}
	
	@BeforeMethod
	public void LoginToApp() throws InterruptedException, EncryptedDocumentException, IOException {
		
		login.clickPBLogINPagesignin();
		monum.inpPBMobNumPageMobNum(Utilityclass.getPFdata("MobNum"));
		monum.clickPBMobNumPagesigninwithpwd();
		pwd.inpPBPwdPagePWD(Utilityclass.getPFdata("PWD"));
		pwd.clickPBPwdPageSignin();
		//homepage.openDDoptionPBHomePageMyacc();
		//myacc.clickPBMyAccPageMyprofile();
		Thread.sleep(2000); 
	}
	@Test
	public void Verifyfullname() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		homepage.openDDoptionPBHomePageMyacc();
		Thread.sleep(2000);
		myacc.clickPBMyAccPageMyprofile();
		myprofile.switchtochildwindow();
		
		
		String actresult=myprofile.getPBMyProfilePagefullname() ;
		String expresult=Utilityclass.getTestdata(0, 2);
		
		Assert.assertEquals(actresult, expresult,"failed bot are diff");
		
		//myprofile.verifyPBMyProfilePagefullname(sh.getRow(0).getCell(2).getStringCellValue());
	}
	
	@AfterMethod
	public void failedSS(ITestResult s1) throws IOException {
		
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			Utilityclass.CaptureScreenshot(driver, TCID);
		}
		
	}
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
