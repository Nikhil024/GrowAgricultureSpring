package com.grow.agriculture.configurations;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.grow.agriculture.beans.RegisterFormBean;
import com.grow.agriculture.beans.UserDetailsFormBean;
import com.grow.agriculture.controllers.GrowAgricultureRequest;
import com.grow.agriculture.dao.ImagesDao;
import com.grow.agriculture.dao.OTPDao;
import com.grow.agriculture.dao.UserDetailsDao;
import com.grow.agriculture.dao.UsersDao;
import com.grow.agriculture.daoImpl.ImagesDaoImpl;
import com.grow.agriculture.daoImpl.OTPDaoImpl;
import com.grow.agriculture.daoImpl.UserDetailsDaoImpl;
import com.grow.agriculture.daoImpl.UsersDaoImpl;
import com.grow.agriculture.form.validators.OTPValidator;
import com.grow.agriculture.form.validators.RegisterValidator;
import com.grow.agriculture.form.validators.UserDetailsValidator;
import com.grow.agriculture.helper.MD5PasswordEncryptionHelper;
import com.grow.agriculture.helper.OTPHelper;
import com.grow.agriculture.helper.UserDetailsHelper;
import com.grow.agriculture.helper.UsersHelper;
import com.grow.agriculture.service.ConfigurationService;
import com.grow.agriculture.service.ImagesService;
import com.grow.agriculture.service.JsonReaderService;
import com.grow.agriculture.service.OTPService;
import com.grow.agriculture.service.UserDetailsService;
import com.grow.agriculture.service.UsersService;
import com.grow.agriculture.serviceImpl.ConfigurationServiceImpl;
import com.grow.agriculture.serviceImpl.ImagesServiceImpl;
import com.grow.agriculture.serviceImpl.JsonReaderServiceImpl;
import com.grow.agriculture.serviceImpl.OTPServiceImpl;
import com.grow.agriculture.serviceImpl.UserDetailsServiceImpl;
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
	
	/*@Value("${database.classname}")
	private String databaseClassName;

	@Value("${database.url}")
	private String databaseUrl;
	
	@Value("${database.username}")
	private String databaseUsername;
	
	@Value("${database.password}")
	private String databasePassword;
	*/
	
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
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
	
	/* Hibernate Configuration */
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManagerDatasource = new DriverManagerDataSource();
		driverManagerDatasource.setDriverClassName(environment.getProperty("database.classname"));//databaseClassName);
		driverManagerDatasource.setUrl(environment.getProperty("database.url"));//databaseUrl); //"jdbc:oracle:thin:172.30.55.61:1521:XE"));
		driverManagerDatasource.setUsername(environment.getProperty("database.username"));//databaseUsername);//"nikhil");
		driverManagerDatasource.setPassword(environment.getProperty("database.password"));//databasePassword);//"admin");
		return driverManagerDatasource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.learning.beans");
		return builder.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dailect", environment.getProperty("database.dailect"));
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		/*properties.put("hibernate.hbm2ddl.auto", "update");*/
		return properties;
	}
	
	/*@Bean
	public NamedParameterJdbcTemplate jdbcTemplate(){
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
		return namedParameterJdbcTemplate;
	}*/
	
	//FileUpload
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(15000000);
		return commonsMultipartResolver;
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
	
	@Bean
	public UserDetailsFormBean userDetailsFormBean(){
		return new UserDetailsFormBean();
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
	 
	 @Bean
	 public UserDetailsValidator userDetailsValidator() {
	        return new UserDetailsValidator();
	    }
	 
	 //Dao
	 @Bean
	 public UsersDao usersDao() {
	        return new UsersDaoImpl();
	    }
	 
	 @Bean
	 public OTPDao otpDao(){
		 return new OTPDaoImpl();
	 }
	 
	 @Bean
	 public UserDetailsDao userDetailsDao(){
		 return new UserDetailsDaoImpl();
	 }
	 
	 @Bean
	 public ImagesDao imagesDao() {
		 return new ImagesDaoImpl();
	 }
	 
	 //Service
	 @Bean
	 public UsersService usersService() {
	        return new UsersServiceImpl();
	    }
	 
	 @Bean
	 public OTPService otpService(){
		 return new OTPServiceImpl();
	 }
	 
	 @Bean
	 public UserDetailsService userDetailsService(){
		 return new UserDetailsServiceImpl();
	 }
	 
	 @Bean
	 public ImagesService imagesService() {
		 return new ImagesServiceImpl();
	 }
	 
	 //Helper
	 @Bean
	 public UsersHelper usersHelper() {
	        return new UsersHelper();
	    }
	 
	 @Bean
	 public OTPHelper otpHelper(){
		 return new OTPHelper();
	 }
	 
	 @Bean
	 public UserDetailsHelper userDetailsHelper(){
		 return new UserDetailsHelper();
	 }
	 
	 @Bean
	 public MD5PasswordEncryptionHelper mD5PasswordEncryptionHelper(){
		 return new MD5PasswordEncryptionHelper();
	 }
	 
}
