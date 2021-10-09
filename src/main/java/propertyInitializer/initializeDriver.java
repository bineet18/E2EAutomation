package propertyInitializer;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class initializeDriver extends initializeConfiguration
{
	Properties propC;
	WebDriver driver;
	String browser;
	public initializeDriver() throws IOException
	{
		this.propC = super.propC;
	}
	
	public WebDriver returnDriver()
	{
		browser = propC.getProperty("browser");
		String path = System.getProperty("user.dir");
		
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", path+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("FIrefox"))
		{
			System.setProperty("webdriver.gecko.driver", path+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", path+"/Drivers/edgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(propC.getProperty("driverTimeout")), TimeUnit.SECONDS);
		
		
		return driver;
	}
}
