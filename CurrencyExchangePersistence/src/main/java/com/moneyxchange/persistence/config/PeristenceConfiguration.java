package com.moneyxchange.persistence.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.moneyxchange.persistence.dao")
@EnableTransactionManagement
@ComponentScan({"com.moneyxchange.persistence.dao","com.moneyxchange.persistence.service"})
public class PeristenceConfiguration {
	private final String databaseUrl;
	private final String databaseDriver;
	private final String databaseUserName;
    private final String databasePassword;
    @Autowired
    public PeristenceConfiguration() {
    	this.databaseUrl = "jdbc:postgresql://localhost:5433/currency_exchange";
		this.databaseDriver = "org.postgresql.Driver";
		this.databaseUserName =  "postgres";
		this.databasePassword = "postgres";
    }
	
	@Bean
	public DataSource dataSource() {

		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(databaseDriver);
		dataSource.setJdbcUrl(databaseUrl);
		dataSource.setUsername(databaseUserName);
		dataSource.setPassword(databasePassword);
		dataSource.setIdleTimeout(120000);//Dos minutos
		dataSource.setMaximumPoolSize(20);
		dataSource.setMinimumIdle(5);
		dataSource.setConnectionTimeout(45000);
		return dataSource;
	}
	/**
	 * Creates an entityManagerFactory based on the datasource
	 *
	 * @param dataSource the Hikari datasource
	 * @return an entityManagerFactory based on the datasource
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPackagesToScan("com.moneyxchange.persistence.entities");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setJpaProperties(additionalProperties());

		return entityManagerFactoryBean;
	}

	/**
	 * Creates the transaction manager
	 *
	 * @param entityManagerFactory the entityManagerFactory bean
	 * @return the transaction manager
	 */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);

		return transactionManager;
	}

	/**
	 * Creates a translator for exceptions thrown on the entityManagerFactory initialization
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * Creates a map with additional properties for hibernate
	 *
	 * @return a map with additional properties for hibernate
	 */
	private Properties additionalProperties() {

		Properties properties = new Properties();

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
		properties.setProperty("hibernate.physical_naming_strategy",
				"org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
		properties.setProperty("hibernate.show_sql", "false");
		//properties.setProperty("hibernate.default_schema", "vr");
		return properties;
	}
	
}
