package com.grow.agriculture.configurations;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
import com.grow.agriculture.dao.UsersDao;
import com.grow.agriculture.daoImpl.UsersDaoImpl;
import com.grow.agriculture.form.validators.OTPValidator;
import com.grow.agriculture.form.validators.RegisterValidator;
import com.grow.agriculture.helper.UsersHelper;
import com.grow.agriculture.service.ConfigurationService;
import com.grow.agriculture.service.JsonReaderService;
import com.grow.agriculture.service.UsersService;
import com.grow.agriculture.serviceImpl.ConfigurationServiceImpl;
import com.grow.agriculture.serviceImpl.JsonReaderServiceImpl;
import com.grow.agriculture.serviceImpl.UsersServiceImpl;

@EnableWebMvc //mvc:annotation-driven
@Configuration
@PropertySource(value = { "classpath:jdbc.properties" })
@EnableTransactionManagement
@ComponentScan({ "com.grow.agriculture.controllers" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {
	private static final Logger logger = Logger.getLogger(SpringWebConfig.class);
	
	@Autowired
    ApplicationContext applicationContext;
	
	@Autowired
    Environment environment;
	
	@PostConstruct
    public void logBeans() {
        logger.debug(StringUtils.repeat('*', 78));
        for (String bean : applicationContext.getBeanDefinitionNames()) {
            logger.info("BEAN '{}'"+ bean);
        }
        logger.debug(StringUtils.repeat('*', 78));
        logger.debug("ENV: '{}'"+ environment.toString());
        logger.debug(StringUtils.repeat('*', 78));
    }
	
	@Value("${database.classname}")
	private String databaseClassName;

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
	public DataSource dataSource(){
		DriverManagerDataSource driverManagerDatasource = new DriverManagerDataSource();
		driverManagerDatasource.setDriverClassName(databaseClassName);
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
	
	@Bean
	public JsonReaderService jsonReaderService(){
		return new JsonReaderServiceImpl();
	}
	
	 @Bean
	 public GrowAgricultureRequest gaRequest() {
	        return new GrowAgricultureRequest();
	    }
	 
	 @Bean
	 public ConfigurationService configurationService() {
	        return new ConfigurationServiceImpl();
	    }
	
	//FormBean
	@Bean
	 public RegisterFormBean registerFormBean() {
	        return new RegisterFormBean();
	    }
	
	 //Validators
	 @Bean
	 public OTPValidator otpValidator() {
	        return new OTPValidator();
	    }
	 
	 @Bean
	 public RegisterValidator registerValidator() {
	        return new RegisterValidator();
	    }
	 
	 //Dao
	 @Bean
	 public UsersDao usersDao() {
	        return new UsersDaoImpl();
	    }
	 
	 //Service
	 @Bean
	 public UsersService usersService() {
	        return new UsersServiceImpl();
	    }
	 
	 //Helper
	 @Bean
	 public UsersHelper usersHelper() {
	        return new UsersHelper();
	    }
	 
}
