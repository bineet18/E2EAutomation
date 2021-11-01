package propertyInitializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class initializeConfiguration 
{
	public Properties propC;
	
	public initializeConfiguration() throws IOException
	{
		propC = new Properties();
		
		FileInputStream fis = new FileInputStream("config.properties");
		propC.load(fis);
	}
	
	public Properties returnConfiguration()
	{return propC;}
}
