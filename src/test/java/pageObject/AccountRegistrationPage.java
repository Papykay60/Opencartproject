package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	
	{
		this.driver=driver;	
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	WebElement txtFirstName;
	
	
	@FindBy(name="lastname")
	WebElement txtLastname;
	
	
	@FindBy(name="email")
	WebElement txtEmail;            
	   
	
	@FindBy(name="telephone")
	WebElement txtTelephone; 
	
	@FindBy(id="input-password")
	WebElement txtPassword;   
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmPasword;  
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement MsgConfirmation;
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cnfpwd)
	{
		txtConfirmPasword.sendKeys(cnfpwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}

	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
		return (MsgConfirmation.getText());
		}
		catch(Exception e)
		{
		return(e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
	
}
