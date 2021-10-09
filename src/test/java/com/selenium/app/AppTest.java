package com.selenium.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.checkbox;
import pageActions.radioButton;

import propertyInitializer.initializeConfiguration;
import propertyInitializer.initializeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	static Properties propC;
	static WebDriver driver;
	
	@BeforeClass
	public void beforeMethod() throws IOException
	{
		
		initializeConfiguration c = new initializeConfiguration(); // Initialize the Configuration File
		propC = c.returnConfiguration();
		
		initializeDriver i= new initializeDriver(); // Initialize the WebDriver
		driver = i.returnDriver();
		driver.manage().window().maximize(); // Maximize the Window
		
    	driver.get(propC.getProperty("URL"));
	}
	
	
    @Test
    public void ClickOnRadioButtons() throws IOException
    {
    	new radioButton(driver).clickOnRadioButton1();
    	new radioButton(driver).clickOnRadioButton2();
    	new radioButton(driver).clickOnRadioButton3();    	
    }
    
    
    @Test
    public void ClickOnCheckboxes() throws IOException
    {
    	new checkbox(driver).clickOnCheckbox1();
    	new checkbox(driver).clickOnCheckbox2();
    	new checkbox(driver).clickOnCheckbox3();
    	
    }
}
