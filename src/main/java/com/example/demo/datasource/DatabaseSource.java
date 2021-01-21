package com.example.demo.datasource;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@ConfigurationProperties("app.datasource")
public class DatabaseSource extends HikariConfig {

	@Bean
	@ConfigurationProperties("app.datasource")
	public DataSource dataSource() throws SQLException {
		return new HikariDataSource();
	}
}
