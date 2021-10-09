package pageActions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import propertyInitializer.initializeXpath;

public class checkbox extends initializeXpath
{
	WebDriver driver;
	Properties propX;
	public checkbox(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		this.propX = super.propX;
	}
	
	public void clickOnCheckbox1()
	{
		driver.findElement(By.xpath(propX.getProperty("checkbox1"))).click();
	}
	
	public void clickOnCheckbox2()
	{
		driver.findElement(By.xpath(propX.getProperty("checkbox2"))).click();
	}
	
	public void clickOnCheckbox3()
	{
		driver.findElement(By.xpath(propX.getProperty("checkbox3"))).click();
	}
	
}
