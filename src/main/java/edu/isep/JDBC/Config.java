package edu.isep.JDBC;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:config.properties")
public class Config {
 @Autowired
 private Environment env;

	@Bean
	public DataSource dataSource() {
     String username = env.getProperty("db.username");
     String password = env.getProperty("db.password");
     String url = env.getProperty("db.url");
     String driverClassName = env.getProperty("db.driverClassName");

	  DriverManagerDataSource ds = new DriverManagerDataSource();
	  ds.setDriverClassName(driverClassName);
	  ds.setUrl(url);
	  ds.setUsername(username);
	  ds.setPassword(password);
	  return ds;
	}
	
	@Bean
	public JdbcOperations jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);		
	}

}
