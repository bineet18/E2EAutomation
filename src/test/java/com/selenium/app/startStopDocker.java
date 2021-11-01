package com.selenium.app;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class startStopDocker 
{
	@BeforeTest
	public void startDocker() throws IOException, InterruptedException
	{
		  String[] command1 = {"/bin/bash","-c", "docker-compose up -d"}; 
		  Process proc1 = new ProcessBuilder(command1).start();
		  proc1.waitFor();
		  
		  String[] command2 = {"/bin/bash","-c", "docker-compose scale chrome=5"}; 
		  Process proc2 = new ProcessBuilder(command2).start();
		  proc2.waitFor();
	}
	
	@AfterTest
	public void stopDocker() throws IOException, InterruptedException
	{
		  String[] command3 = {"/bin/bash","-c", "docker-compose down"}; 
		  Process proc3 = new ProcessBuilder(command3).start();
		  proc3.waitFor();
	}
}
