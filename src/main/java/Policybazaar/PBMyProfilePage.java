package Policybazaar;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyProfilePage {
	
 @FindBy(xpath = "//input[@name='personName']") private WebElement fullname;
 WebDriver driver1;
 
 public PBMyProfilePage(WebDriver driver) 
 {
	PageFactory.initElements(driver,this);
	driver1=driver;
}
 
 public void switchtochildwindow() 
 {
   Set<String> allids = driver1.getWindowHandles();
   ArrayList<String> al=new ArrayList<String>(allids);
   //ArrayList<String> al=new ArrayList<>(allids);
   driver1.switchTo().window(al.get(1));
}
 
 
 public String getPBMyProfilePagefullname() {
	 
	  String actfullname = fullname.getAttribute("value");
	  return actfullname;
	
}
 
 
 
 
 
 
 
 
 //public void verifyPBMyProfilePagefullname(String expname) {
	//String actname = fullname.getAttribute("value");
	//String expname="sabhyata sanjay moon";
	
	//if(actname.equals(expname))
	//{
		//System.out.println("TC pass");
	//}
	//else
	//{
	//	System.out.println("TC fail");
	//}
	
//}
	
}