package com.emusicstore.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.emusicstore.models.Authorities;
import com.emusicstore.models.BillingAddress;
import com.emusicstore.models.Cart;
import com.emusicstore.models.CartItem;
import com.emusicstore.models.Customer;
import com.emusicstore.models.CustomerOrder;
import com.emusicstore.models.Product;
import com.emusicstore.models.ShippingAddress;
import com.emusicstore.models.Users;

@Configuration
@EnableWebMvc
@EnableWebSecurity
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
           registry.addResourceHandler("/resources/**")
           .addResourceLocations("/WEB-INF/resources/");
     }
	 
	 /*creating a BasicDataSource data source*/
	 
	 @Bean(name = "dataSource")
	 public DataSource getDataSource() {
		 
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 dataSource.setUrl("jdbc:mysql://localhost:3306/emusicstore");
		 dataSource.setUsername("root");
		 dataSource.setPassword("r@dm09d");
		 
		 return dataSource;
	 }
	 
	 /*creating hibernate mapping using session factory*/
	 
	 @Autowired
	 @Bean(name = "sessionFactory")
	 public SessionFactory getSessionFactory(DataSource dataSource) {
		 
		 LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		 sessionBuilder.addProperties(getHibernateProperties());
		 sessionBuilder.addAnnotatedClasses(Product.class);
		 sessionBuilder.addAnnotatedClasses(CartItem.class);
		 sessionBuilder.addAnnotatedClasses(Cart.class);
		 sessionBuilder.addAnnotatedClasses(Customer.class);
		 sessionBuilder.addAnnotatedClasses(BillingAddress.class);
		 sessionBuilder.addAnnotatedClasses(ShippingAddress.class);
		 sessionBuilder.addAnnotatedClasses(Users.class);
		 sessionBuilder.addAnnotatedClasses(Authorities.class);
		 sessionBuilder.addAnnotatedClasses(CustomerOrder.class);
		 return sessionBuilder.buildSessionFactory();
	 }
	 
	 private Properties getHibernateProperties() {
		 
		 Properties properties = new Properties();
		 properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
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
	 
	 @Bean(name = "multipartResolver")
	 public CommonsMultipartResolver mulitpartResolver() throws IOException {
		 CommonsMultipartResolver fileResolver = new CommonsMultipartResolver();
		 fileResolver.setUploadTempDir(new FileSystemResource("/resources/images"));
		 fileResolver.setMaxUploadSize(1024000);
		 fileResolver.setMaxInMemorySize(0);
		 return fileResolver;
		 
	 }
}
