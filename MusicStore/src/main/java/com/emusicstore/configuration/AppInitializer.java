package com.emusicstore.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.emusicstore.models.Product;

@Configuration
@EnableWebMvc
@ComponentScan("com.emusicstore.*")
//annotation to enable transaction, xml equivalent to <tx:annotation-driven>
@EnableTransactionManagement
public class AppInitializer  extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	 @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/resources/**").addResourceLocations("WEB-INF/resources/");
     }
	 
	 /*creating a BasicDataSource data source*/
	 
	 @Bean(name = "dataSource")
	 public DataSource getDataSource() {
		 
		 BasicDataSource dataSource = new BasicDataSource();
		 dataSource.setDriverClassName("org.h2.Driver");
		 dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		 dataSource.setUsername("sa");
		 dataSource.setPassword("");
		 
		 return dataSource;
	 }
	 
	 /*creating hibernate mapping using session factory*/
	 
	 @Autowired
	 @Bean(name = "sessionFactory")
	 public SessionFactory getSessionFactory(DataSource dataSource) {
		 
		 LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		 sessionBuilder.addProperties(getHibernateProperties());
		 sessionBuilder.addAnnotatedClasses(Product.class);
		 
		 return sessionBuilder.buildSessionFactory();
	 }
	 
	 private Properties getHibernateProperties() {
		 
		 Properties properties = new Properties();
		 properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		 properties.setProperty("hibernate.hbm2ddl.auto", "update");
		 properties.setProperty("hibernate.show_sql", "true");
		 properties.setProperty("hibernate.format_sql", "true");
		 
		 return properties;
	 }
	 
	 /*HibernateTransactionManager Object that takes sessionFactory Object to create hibernate transactions */
	 
	 @Autowired
	 @Bean(name = "transactionManager")
	 public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		 
		 HibernateTransactionManager transactionManger = new HibernateTransactionManager(sessionFactory);
		 
		 return transactionManger;
	 }
}
