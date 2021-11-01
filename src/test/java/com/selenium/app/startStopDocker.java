package com.selenium.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class startStopDocker {
	@BeforeTest
	public void startDocker() throws IOException, InterruptedException {
		String[] command1 = { "/bin/bash", "-c", "docker-compose up -d" };
		Process proc1 = new ProcessBuilder(command1).start();

		BufferedReader reader = new BufferedReader(new InputStreamReader(proc1.getInputStream()));

		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.print(line + "\n");
		}

		proc1.waitFor();
		
		
		

		String[] command2 = { "/bin/bash", "-c", "docker-compose scale chrome=5" };
		Process proc2 = new ProcessBuilder(command2).start();
		
		reader = new BufferedReader(new InputStreamReader(proc2.getInputStream()));

		line = "";
		while ((line = reader.readLine()) != null) {
			System.out.print(line + "\n");
		}

		proc2.waitFor();
	}

	@AfterTest
	public void stopDocker() throws IOException, InterruptedException {
		String[] command3 = { "/bin/bash", "-c", "docker-compose down" };
		Process proc3 = new ProcessBuilder(command3).start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc3.getInputStream()));

		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.print(line + "\n");
		}
		
		proc3.waitFor();
	}
}
