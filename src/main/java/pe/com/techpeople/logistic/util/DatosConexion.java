package pe.com.techpeople.logistic.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix= "spring.datasource2")
public class DatosConexion {
	
    private String driverclassname;
    private String url;
    private String username;
    private String password;
    private String schema;
	
	public DatosConexion() {

	}
	
	public DatosConexion(String driverclassname, String url, String username, String password,String schema) {
		super();
		this.driverclassname = driverclassname;
		this.url = url;
		this.username = username;
		this.password = password;
		this.schema=schema;
	}
	
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getDriverclassname() {
		return driverclassname;
	}
	public void setDriverclassname(String driverclassname) {
		this.driverclassname = driverclassname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
