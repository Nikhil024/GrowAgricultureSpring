package com.grow.agriculture.serviceImpl;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.grow.agriculture.service.ConfigurationService;

public class ConfigurationServiceImpl implements ConfigurationService {
	
	private static final Logger LOG = Logger.getLogger(ConfigurationServiceImpl.class);

	@Override
	public Configuration getConfiguration() {
		Configuration config = null;
		try {
			config = new PropertiesConfiguration("local.properties");
			return config;
		} catch (ConfigurationException e) {
			LOG.info("Local.properties file not found ");
		}
		return config;
		
		
	}
}
