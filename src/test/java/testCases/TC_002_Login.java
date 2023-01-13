package testCases;
import org.testng.asserts.*;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
	@Test(groups={"sanity","master"})
	public void Login()
	{
	  logger.info("TC_002_Login test started");
	
	  try
	  {
		  
	  driver.get(rb.getString("appURL"));
	  logger.info("Home page is displayed");
	  
	  driver.manage().window().maximize();
	  
	  HomePage hp= new HomePage(driver);
	  hp.clickMyaccount();
	  logger.info("Clicked on My Account");
	  
	  Thread.sleep(3000);
	  hp.clicklogin();
	  logger.info("Clicked on login");
	  
	  LoginPage lp =new LoginPage(driver);
	  
	  lp.setEmail(rb.getString("email"));
	  logger.info("email");
	  
	  lp.setPassword(rb.getString("password"));
	  logger.info("Password entered");
	  
	  lp.clickLogin();
	  logger.info("Clicked on login");
	  
	  boolean targetpage=lp.isMyAccountPageExists();
	  if(targetpage)
	  {
		  logger.info("login success");
		  Assert.assertTrue(true);
	  }
	  else
	  {
	       logger.error("Login Failed");
	       captureScreen(driver, "test_login");
	       Assert.assertTrue(false);
	  }
	  
	  }
	  catch(Exception e)
	  {
	
	 {
		logger.fatal("Login Failed");
		Assert.fail();
	  }
	
	 logger.info("Finished TC_002_Login");
	
	
	}
	

}
	
	
	
	
	
	
	
	
	
	
	
	

}
