package pojo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class convertToJson 
{
	public void convertArrayListToJSON(List<customerDetails> s)
			throws StreamWriteException, DatabindException, IOException 
	{
		ObjectMapper o = new ObjectMapper();

		System.out.println(o.writeValueAsString(s));
		
		JSONArray a = new JSONArray();
		a.addAll(s);
		
		JSONObject j = new JSONObject();
		j.put("data", a);
		
		o.writeValue(new File("/media/bineet/Data/eclipse-workspace/E2ESeleniumAutomation/customerImport.json"), 
				j);


	}
}

