package pe.com.techpeople.logistic.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
	
	@Autowired
	DatosConexion datosConexion;
	
	@Bean(name="dataSource")
	public DataSource dataSource() {
		  DriverManagerDataSource dataSource =  new DriverManagerDataSource();
		  


		  dataSource.setDriverClassName(datosConexion.getDriverclassname());
		  dataSource.setUrl(datosConexion.getUrl());
		  dataSource.setUsername(datosConexion.getUsername());
		  dataSource.setPassword(datosConexion.getPassword());
		  dataSource.setSchema(datosConexion.getSchema());
		return dataSource;
	}

}
