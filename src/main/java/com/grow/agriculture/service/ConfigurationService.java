package com.grow.agriculture.service;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;

public interface ConfigurationService
{
	public Configuration getConfiguration() throws ConfigurationException ;
	
	
}
