package com.selenium.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import database.connectToMySQL;
import pageActions.checkbox;
import pageActions.radioButton;
import pojo.convertToJson;
import pojo.customerDetails;
import propertyInitializer.initializeConfiguration;
import propertyInitializer.initializeDriver;

public class mainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, StreamWriteException, DatabindException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
			
			  String[] command1 = {"/bin/bash","-c", "docker-compose up -d"}; 
			  Process proc1 = new ProcessBuilder(command1).start();
			  proc1.waitFor();
			  
			  String[] command2 = {"/bin/bash","-c", "docker-compose scale chrome=5"}; 
			  Process proc2 = new ProcessBuilder(command2).start();
			  proc2.waitFor();
			  
				
			  String[] command3 = {"/bin/bash","-c", "docker-compose down"}; 
			  Process proc3 = new ProcessBuilder(command3).start();
			  proc3.waitFor();
				 
			 		
		
		/*
		 * Properties propC; WebDriver driver;
		 * 
		 * initializeConfiguration c = new initializeConfiguration(); // Initialize the
		 * Configuration File propC = c.returnConfiguration();
		 * 
		 * initializeDriver i= new initializeDriver(); // Initialize the WebDriver
		 * driver = i.returnDriver(); driver.manage().window().maximize(); // Maximize
		 * the Window
		 * 
		 * driver.get(propC.getProperty("URL"));
		 * 
		 * new radioButton(driver).clickOnRadioButton1(); new
		 * radioButton(driver).clickOnRadioButton2(); new
		 * radioButton(driver).clickOnRadioButton3();
		 * 
		 * 
		 * new checkbox(driver).clickOnCheckbox1(); new
		 * checkbox(driver).clickOnCheckbox2(); new checkbox(driver).clickOnCheckbox3();
		 * 
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.close(); driver.quit();
		 */
		  
	}

}
