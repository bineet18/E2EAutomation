package propertyInitializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class initializeXpath 
{
	public Properties propX;
	
	public initializeXpath() throws IOException
	{
		propX = new Properties();
		
		FileInputStream fis = new FileInputStream("xpath.properties");
		propX.load(fis);
	}
}
