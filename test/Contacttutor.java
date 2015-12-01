package test;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Contacttutor {

	private WebDriver driver;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  Properties obj = new Properties();
	  @Before
	  public void setUp() throws Exception {   	  
			driver =  new FirefoxDriver();
			login(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  }
	  
	  @Test
	  public void testContactTutor() throws Exception {
	    
	   
	    driver.findElement(By.xpath(obj.getProperty("StudentFirstName"))).clear();
	    
	    
	    driver.findElement(By.xpath(obj.getProperty("StudentFirstName"))).sendKeys(obj.getProperty("FName"));
	    
	    driver.findElement(By.xpath(obj.getProperty("StudentLastName"))).clear();
	    driver.findElement(By.xpath(obj.getProperty("StudentLastName"))).sendKeys(obj.getProperty("LName"));
	    
	    
	    driver.findElement(By.xpath(obj.getProperty("payercheckbox"))).click();
	    
	    driver.findElement(By.xpath(obj.getProperty("yourEmail"))).clear();
	    driver.findElement(By.xpath(obj.getProperty("yourEmail"))).sendKeys(obj.getProperty("EmailAddress"));
	    driver.findElement(By.xpath(obj.getProperty("yourEmail"))).clear();
	    driver.findElement(By.xpath(obj.getProperty("yourEmail"))).sendKeys(obj.getProperty("EmailAddress"));
	    driver.findElement(By.xpath(obj.getProperty("yourPhone"))).clear();
	    driver.findElement(By.xpath(obj.getProperty("yourPhone"))).sendKeys(obj.getProperty("Pnumber"));
	    driver.findElement(By.xpath(obj.getProperty("subject"))).clear();
	    driver.findElement(By.xpath(obj.getProperty("subject"))).sendKeys(obj.getProperty("Tutorsubject"));
	    driver.findElement(By.xpath(obj.getProperty("Payermessage"))).clear();
	    driver.findElement(By.xpath(obj.getProperty("Payermessage"))).sendKeys(obj.getProperty("Message"));
	    
	    driver.findElement(By.xpath(obj.getProperty("privacypolicy"))).click();
	    
	    driver.findElement(By.xpath(obj.getProperty("Submit"))).click();
	    try {
	      assertEquals("Thank you for contacting this tutor", driver.findElement(By.cssSelector("h2")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    driver.quit();
	  }
	  
	  public void login(WebDriver driver) throws Exception{
			
			FileInputStream fis = new FileInputStream("C:\\Automation\\Noodle\\Tutor");
			obj.load(fis); 
			driver.get(obj.getProperty("url"));
			driver.manage().window().maximize();
			
		}
}





 
 

 

 
 
