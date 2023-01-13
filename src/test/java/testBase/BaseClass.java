package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public Logger logger;
public ResourceBundle rb;

public WebDriver driver;
	
	@BeforeClass(groups={"master","regression","sanity"})
	@Parameters({"browser"})
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");
		
	 logger=LogManager.getLogger(this.getClass());
	 
	 if(br.equals("chrome"))
	 {
     WebDriverManager.chromedriver().setup();
     driver= new ChromeDriver();
     logger.info("Chrome browser launched");
	 }
	 else  if(br.equals("edge"))
	 {
		 WebDriverManager.edgedriver().setup();
	     driver= new EdgeDriver();
	     logger.info("Edge browser launched");
	 }
	 else  if(br.equals("firefox"))
	 {
		 WebDriverManager.firefoxdriver().setup();
	     driver= new FirefoxDriver();
	     logger.info("Firefox browser launched");
	 } 
		
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	 
			
	    
		 }
	 
	
     
     
     
     
     
	
		

@AfterClass
public void Teardown() throws InterruptedException
{
	Thread.sleep(20000);
	driver.close();
}


    public String randomestring() {
    	String generatedString=RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
		
}
  // when you want random number for your execution.
    public int randomeNumber() {
    	String generatedString2=RandomStringUtils.randomNumeric(5);
		return (Integer.parseInt(generatedString2));

    }
    
    public void captureScreen(WebDriver driver, String tname) throws IOException
    {
    
    	TakesScreenshot ts= (TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File target=new File(System.getProperty("user.dir")+"\\screenshot\\"+tname+ ".png");
    	FileUtils.copyFile(source, target);
    }
}