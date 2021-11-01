package utilities;

import java.io.IOException;

import org.testng.annotations.Test;

public class startDockerContainers 
{
	@Test
	public void startDocker() throws IOException
	{
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("/bin/bash /home/bineet/UdemyCourses/dockerComposeCommand.sh");
	}
}
