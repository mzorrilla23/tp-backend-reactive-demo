package pe.com.techpeople.logistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;

import io.r2dbc.spi.ConnectionFactory; 

@SpringBootApplication
public class TechsoftApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TechsoftApplication.class, args);
	}

	  @Bean
	    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		  	System.out.println("ConnectionFactoryInitializer");
	        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
	        initializer.setConnectionFactory(connectionFactory);

	        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
	        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
	      //  populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
	        initializer.setDatabasePopulator(populator);

	        return initializer;
	    }
	
}
