package com.example.Springbootcrud;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
public class SpringBootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}
	@Profile("dev")
	@Bean
	public DataSource getDataSource() {
		
		/*return DataSourceBuilder
				.create()
				.username("vidya")
				.password("vidya")
				.driverClassName("com.jdbc.OracleDriver")
				.url("jdbc:oracle:thin:@localhost:1521/xe")
				.build();*/
		
		EmbeddedDatabaseBuilder edb=new EmbeddedDatabaseBuilder();
		edb.setType(EmbeddedDatabaseType.H2);
		return edb.build(); 
	}
	@Profile("test")
	@Bean
	public DataSource gettestDataSource() {
		return DataSourceBuilder.create().build();
	}
		
}
