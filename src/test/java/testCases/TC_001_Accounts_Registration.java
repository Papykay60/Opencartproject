package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_Accounts_Registration extends BaseClass
{
	
	
	@Test(groups={"regression","master"})
	public void test_account_Registration() throws InterruptedException
	{
	    logger.info("Starting TC_Accounts_Registration");
	    try
	    {
	    driver.get(rb.getString("appURL"));
	    logger.info("Home page displayed");
	    driver.manage().window().maximize();
	    
	    HomePage hp=new HomePage(driver);
	    hp.clickMyaccount();
	    logger.info("Click on My Account");
	    hp.clickRegister();
	    logger.info("Click on My Register");
	    AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
	    
	    regPage.setFirstName("Kay");
	    logger.info("Provided Firstname");
	    regPage.setLastName("Papy");
	    logger.info("Provided LastName");
	    regPage.setEmail(randomestring()+"@yahoo.com");
	    logger.info("Provided Email");
	    regPage.setTelephone("0782856611");
	    logger.info("Provided Telephone number");
	    regPage.setPassword(rb.getString("password"));
	    logger.info("Provided Password");
	    regPage.setConfirmPassword(rb.getString("password"));
	    logger.info("Provided Confirm Password");
	    regPage.setPrivacyPolicy();
	    logger.info("set privacy policy");
	    regPage.clickContinue();
	    logger.info("Click on continue");
	    Thread.sleep(2000);
	    
	    String confmsg=regPage.getConfirmationMsg();
	    
	    if(confmsg.equals("Your Account Has Been Created!"))
	    {
	      logger.info("Account Registration success");
	      Assert.assertTrue(true); 
	    }
	    else
	    {
	    	logger.info("Account Registration failed");
	    	
	    	captureScreen(driver," test_account_Registration");
	    	Assert.assertTrue(false);
	    }
	    }
	    catch(Exception e)
	    {
	    	logger.error("Account Registration failed");
	    	Assert.fail();
	    }
	    logger.info("Finished TC_Accounts_Registration ");
	

}	
	
}	
	
	
	
	
   

