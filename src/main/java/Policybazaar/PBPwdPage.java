package Policybazaar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPwdPage {

	@FindBy(xpath = "//input[@type='password']") private WebElement enterPwd;
	@FindBy(xpath = "//span[text()='Sign in']") private WebElement signin;
	
	public PBPwdPage(WebDriver driver)
	{
       PageFactory.initElements(driver,this);
	}
	
	public void inpPBPwdPagePWD(String password) {
		enterPwd.sendKeys(password);
	}
	
	public void clickPBPwdPageSignin() {
		signin.click();
	}
	
}
