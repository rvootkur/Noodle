package test;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Search {
public WebDriver driver;
private StringBuffer verificationErrors = new StringBuffer();
  
  Properties obj = new Properties();

  @Before
  public void setUp() throws Exception {   	  
	driver =  new FirefoxDriver();
	login(driver);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void testSearch1() throws Exception {
   
    driver.findElement(By.xpath(obj.getProperty("BrowseOurTutors"))).click();    
    driver.findElement(By.xpath(obj.getProperty("Subject"))).click();
    driver.findElement(By.xpath(obj.getProperty("Accounting"))).click();
    
    try {
      assertEquals("Find A Tutor | One With USC Rossier", driver.getTitle());
            
    } catch (Error e) {
      verificationErrors.append(e.toString());
     
    }
    
    System.out.println("Tutor Page CheckPoint Passed");
    
    driver.findElement(By.xpath(obj.getProperty("Subject"))).click();    
    driver.findElement(By.xpath(obj.getProperty("CarrerDevelopment"))).click();    
    driver.findElement(By.xpath(obj.getProperty("Pricerange"))).clear();    
    driver.findElement(By.xpath(obj.getProperty("Pricerange"))).sendKeys("50");   
    driver.findElement(By.xpath(obj.getProperty("Updatecost"))).click();
        
    try {
          	
    	assertEquals("Rate $45 /Per Hour", driver.findElement(By.xpath(obj.getProperty("Rateperhr"))).getText());
    } catch (Error e) {
     verificationErrors.append(e.toString());
     
    }
    
    System.out.println("Cost Range CheckPoint Passed");
        
    driver.findElement(By.xpath(obj.getProperty("tutlink"))).click();   
    driver.findElement(By.xpath(obj.getProperty("contacttutor"))).click();
    
    try {
          	
    	assertEquals("Stephanie C.",driver.findElement(By.xpath(obj.getProperty("tutorname"))).getText());
    	
      } catch (Error e) {
    	      	     verificationErrors.append(e.toString());
              }
    
    System.out.println("Contact Page CheckPoint Passed");
    
    driver.quit();
    
     }
    
  public void login(WebDriver driver) throws Exception{
		
		FileInputStream fis = new FileInputStream("C:\\Automation\\Noodle\\Search.txt");
		obj.load(fis); 
		driver.get(obj.getProperty("url"));
		driver.manage().window().maximize();
		
	}
  
  

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  } 
  
}
