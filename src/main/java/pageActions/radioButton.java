package pageActions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import propertyInitializer.initializeXpath;

public class radioButton extends initializeXpath
{
	WebDriver driver;
	Properties propX;
	public radioButton(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		this.propX = super.propX;
	}
	
	public void clickOnRadioButton1()
	{
		driver.findElement(By.xpath(propX.getProperty("radio1"))).click();
	}
	
	public void clickOnRadioButton2()
	{
		driver.findElement(By.xpath(propX.getProperty("radio2"))).click();
	}
	
	public void clickOnRadioButton3()
	{
		driver.findElement(By.xpath(propX.getProperty("radio3"))).click();
	}
	
}
