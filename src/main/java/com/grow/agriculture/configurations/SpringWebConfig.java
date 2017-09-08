package com.grow.agriculture.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.grow.agriculture.beans.RegisterFormBean;
import com.grow.agriculture.controllers.GrowAgricultureRequest;
import com.grow.agriculture.form.validators.OTPValidator;
import com.grow.agriculture.form.validators.RegisterValidator;
import com.grow.agriculture.service.ConfigurationService;
import com.grow.agriculture.serviceImpl.ConfigurationServiceImpl;

@EnableWebMvc //mvc:annotation-driven
@Configuration
@PropertySource(value = { "classpath:jdbc.properties" })
@EnableTransactionManagement
@ComponentScan({ "com.grow.agriculture.controllers" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {
	
	/*@Autowired
	private Environment env;
	env.getProperty()
	*/
	
	@Value("${database.url}")
	private String databaseUrl;
	
	@Value("${database.username}")
	private String databaseUsername;
	
	@Value("${database.password}")
	private String databasePassword;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource driverManagerDatasource = new DriverManagerDataSource();
		driverManagerDatasource.setUrl(databaseUrl); //"jdbc:oracle:thin:172.30.55.61:1521:XE"));
		driverManagerDatasource.setUsername(databaseUsername);//"nikhil");
		driverManagerDatasource.setPassword(databasePassword);//"admin");
		return driverManagerDatasource;
	}
	
	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate(){
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
		return namedParameterJdbcTemplate;
		
	}
	
	 public RegisterFormBean registerFormBean() {
	        return new RegisterFormBean();
	    }
	 
	 @Bean
	 public ConfigurationService configurationService() {
	        return new ConfigurationServiceImpl();
	    }
	 
	 @Bean
	 public OTPValidator otpValidator() {
	        return new OTPValidator();
	    }
	 
	 @Bean
	 public RegisterValidator registerValidator() {
	        return new RegisterValidator();
	    }
	 
	 @Bean
	 public GrowAgricultureRequest gaRequest() {
	        return new GrowAgricultureRequest();
	    }
}
