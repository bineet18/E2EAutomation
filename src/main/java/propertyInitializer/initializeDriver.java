package propertyInitializer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class initializeDriver extends initializeConfiguration
{
	Properties propC;
	WebDriver driver;
	String browser;
	public initializeDriver() throws IOException
	{
		this.propC = super.propC;
	}
	
	public WebDriver returnDriver() throws MalformedURLException
	{
		browser = propC.getProperty("browser");
		String path = System.getProperty("user.dir");
		
		if(browser.equals("Chrome"))
		{
			URL u = new URL("http://localhost:4445/wd/hub");
			
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.setCapability("browserVersion", "94");
//			chromeOptions.setCapability("platformName", Platform.WIN10);
			
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(u,capability);
			
			//System.setProperty("webdriver.chrome.driver", path+"/drivers/chromedriver.exe");
			//driver = new ChromeDriver();
			
		}
		
		else if(browser.equals("Firefox"))
		{
			URL u = new URL("http://localhost:4446/wd/hub");
			
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.setCapability("browserVersion", "94");
//			chromeOptions.setCapability("platformName", Platform.WIN10);
			
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(u,capability);
			
			//System.setProperty("webdriver.gecko.driver", path+"/drivers/geckodriver.exe");
			//driver = new FirefoxDriver();
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
