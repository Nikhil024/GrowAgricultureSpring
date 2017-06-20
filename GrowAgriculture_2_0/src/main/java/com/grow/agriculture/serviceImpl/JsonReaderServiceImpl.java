package com.grow.agriculture.serviceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import com.grow.agriculture.service.ConfigurationService;
import com.grow.agriculture.service.JsonReaderService;

public class JsonReaderServiceImpl implements JsonReaderService {
	
	private static final Logger LOG = Logger.getLogger(JsonReaderServiceImpl.class);
	
	private final static String STATUS = "Status";
	private final static String SUCCESS = "Success";
	
	
	
    private ConfigurationService configurationService;

	/*public void demo() throws ConfigurationException{
		LOG.info("Nikhil:::::::: "+configurationService.getConfiguration().getInt("demo"));
	}*/
	

	@Override
	public void jsonReader(String phoneNumber) {
		JSONParser parser = new JSONParser();

		try {         
			URL url = new URL("http://localhost:1234/eShopApp/details"); // URL to Parse
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String inputLine;
			while ((inputLine = bufferReader.readLine()) != null) {               
				JSONArray jsonArray = (JSONArray) parser.parse(inputLine);

				// Loop through each item
				for (Object object : jsonArray) {
					JSONObject jsonObject = (JSONObject) object;

					String status = (String) jsonObject.get(STATUS);
					if(status.equals(SUCCESS)){
						String details = (String) jsonObject.get("device");
					}

					

				}
			}
			bufferReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}   

	}

	@Override
	public void demo() {
		// TODO Auto-generated method stub
		
	}

}
