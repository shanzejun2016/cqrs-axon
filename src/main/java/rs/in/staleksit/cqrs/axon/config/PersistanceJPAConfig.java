package rs.in.staleksit.cqrs.axon.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/rs/in/staleksit/cqrs/axon/cfg/db.properties")
@EnableJpaRepositories("rs.in.staleksit.cqrs.axon.command.repository.catalog")
public class PersistanceJPAConfig {
	
	private static final int MAXIMUM_POOL_SIZE_ACCEPTANCE = 25;
	
	@Autowired
	private Environment env;
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.username}")
	private String dbUsername;
	
	@Value("${db.password}")
	private String dbPassword;
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setMaximumPoolSize(MAXIMUM_POOL_SIZE_ACCEPTANCE);
		ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		ds.addDataSourceProperty("url", dbUrl);
		ds.addDataSourceProperty("user", dbUsername);
		ds.addDataSourceProperty("password", dbPassword);
		return ds;
	}
	
	@Bean
	protected Properties jpaProperties() {
		Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.show_sql", "true");
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
        return jpaProperties;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPersistenceUnitName("pu_cqrs_axon");
		em.setJpaVendorAdapter(getJPAVendorAdapter());
		em.setJpaProperties(jpaProperties());
		em.setPackagesToScan("rs.in.staleksit.cqrs.axon.command.model.catalog.impl");
		em.setDataSource(dataSource());
		em.afterPropertiesSet();
		
		return em;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		final JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}

	@Bean
	public JpaVendorAdapter getJPAVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}	
	
}
