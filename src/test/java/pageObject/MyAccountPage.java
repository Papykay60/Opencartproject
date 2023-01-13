package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPage {
	WebDriver driver;
	
	
	public MyAccountPage(WebDriver Driver)
	{
		this.driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}
	 
	  @FindBy(linkText="Logout")
	  WebElement cliklogout;
	
		
	public void clicklogout() 
	{
		
		cliklogout.click();
	}
		
		
	
	
	
	
	
	

}
