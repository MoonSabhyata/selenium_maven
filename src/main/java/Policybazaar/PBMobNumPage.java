package Policybazaar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMobNumPage {
	public WebDriver driver1;
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement enterMobnum;
	@FindBy(xpath = "(//a[@id='central-loggin-with-pwd'])[2]") private WebElement signinwithpwd;
	
	public PBMobNumPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void inpPBMobNumPageMobNum(String mobilnum) {
		enterMobnum.sendKeys(mobilnum);
	}
	
	public void clickPBMobNumPagesigninwithpwd() {
		signinwithpwd.click();
	}
	
}
