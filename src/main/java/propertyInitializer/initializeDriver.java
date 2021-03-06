package propertyInitializer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class initializeDriver extends initializeConfiguration
{
	Properties propC;
	RemoteWebDriver driver;
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
			URL u = new URL("http://192.168.1.11:4444/wd/hub");
			
			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.setCapability("browserVersion", "94");
//			chromeOptions.setCapability("platformName", Platform.WIN10);
			
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE
			 * THE VERY FIRST OPTION options.addArguments("--headless");
			 * options.setExperimentalOption("useAutomationExtension", false);
			 * options.addArguments("start-maximized"); // open Browser in maximized mode
			 * options.addArguments("disable-infobars"); // disabling infobars
			 * options.addArguments("--disable-extensions"); // disabling extensions
			 * //options.addArguments("--disable-gpu"); // applicable to windows os only
			 * options.addArguments("--disable-dev-shm-usage"); // overcome limited resource
			 * problems
			 */			
			
			//DesiredCapabilities chromeOptions = DesiredCapabilities.chrome();
	        driver = new RemoteWebDriver(u,chromeOptions);
			
			//System.setProperty("webdriver.chrome.driver", path+"/drivers/chromedriver.exe");
			//driver = new ChromeDriver();
			
		}
		
		else if(browser.equals("Firefox"))
		{
			URL u = new URL("http://192.168.1.11:4444/wd/hub");
			
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.setCapability("browserVersion", "94");
//			chromeOptions.setCapability("platformName", Platform.WIN10);
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
	        options.addArguments("--headless");
	        options.addArguments("start-maximized"); // open Browser in maximized mode
	        options.addArguments("disable-infobars"); // disabling infobars
	        options.addArguments("--disable-extensions"); // disabling extensions
	        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			driver = new RemoteWebDriver(u,options);
			
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
