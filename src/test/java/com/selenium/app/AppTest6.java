package com.selenium.app;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import database.connectToMySQL;
import pageActions.checkbox;
import pageActions.radioButton;

import propertyInitializer.initializeConfiguration;
import propertyInitializer.initializeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest6 
{
	static Properties propC;
	static WebDriver driver;
	
	
	  @BeforeClass public void beforeClass() throws IOException {
	  
	  initializeConfiguration c = new initializeConfiguration(); // Initialize the Configuration File 
	  propC = c.returnConfiguration();
	  
	  initializeDriver i= new initializeDriver(); // Initialize the WebDriver
	  driver = i.returnDriver(); driver.manage().window().maximize(); // Maximize  the Window
	  
	  driver.get(propC.getProperty("URL")); }
	 
	
	
    @Test
    public void ClickOnRadioButtons() throws IOException
    {
    	new radioButton(driver).clickOnRadioButton1();
    	new radioButton(driver).clickOnRadioButton2();
    	new radioButton(driver).clickOnRadioButton3();    	
    }
    
    
    @Test(invocationCount = 10)
    public void ClickOnCheckboxes() throws IOException
    {
    	new checkbox(driver).clickOnCheckbox1();
    	new checkbox(driver).clickOnCheckbox2();
    	new checkbox(driver).clickOnCheckbox3();
    	
    }
    
    @Test(enabled=false)
    public void runQuery() throws ClassNotFoundException, SQLException
    {
    	connectToMySQL m = new connectToMySQL();
    	m.makeConnection();
    }
    
    
	
	  @AfterClass public void afterClass() throws IOException {  
		  driver.close(); 
		  driver.quit(); 
	  }
	 
	
}
