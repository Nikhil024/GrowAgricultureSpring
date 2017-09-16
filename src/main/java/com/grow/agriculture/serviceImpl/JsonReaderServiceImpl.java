package com.grow.agriculture.serviceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.grow.agriculture.service.JsonReaderService;

public class JsonReaderServiceImpl implements JsonReaderService {
	
	private static final Logger LOG = Logger.getLogger(JsonReaderServiceImpl.class);
	
	private final static String STATUS = "Status";
	private final static String SUCCESS = "Success";
	private final static String DETAILS = "Details";
	
	
	@Override
	public String sendRestUrl(String URL) throws ConfigurationException {
		//JSONParser parser = new JSONParser();
		try {         
			URL url = new URL(URL); // URL to Parse
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String inputLine;
			while ((inputLine = bufferReader.readLine()) != null) {               
					Object object = JSONValue.parse(inputLine);  
					JSONObject jsonObject = (JSONObject) object;

					String status = (String) jsonObject.get(STATUS);
					if(status.equals(SUCCESS)){
						String details = (String) jsonObject.get(DETAILS);
						return details;
					}else{
						return status;
					}
				}
			bufferReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
