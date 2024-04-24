package pe.com.techpeople.logistic.config;

 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${app.security.jwt-signing-key}")
    private String signingKey;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() 
			.addFilterAfter(new JWTAuthorizationFilter(signingKey), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/app.js").permitAll()
			.antMatchers(HttpMethod.GET, "/app2.js").permitAll()
			.antMatchers(HttpMethod.GET, "/bootstrap.min.css").permitAll()
			.antMatchers(HttpMethod.GET, "/index.html").permitAll()
			.antMatchers(HttpMethod.GET, "/index2.html").permitAll()
			.antMatchers(HttpMethod.GET, "/jquery.min.js").permitAll()
			.antMatchers(HttpMethod.GET, "/sockjs.min.js").permitAll()
			.antMatchers(HttpMethod.GET, "/stomp.min.js").permitAll()
			.antMatchers(HttpMethod.GET, "/websocket-example/**").permitAll()
			.antMatchers("/h2-console/**").permitAll() // Permitir acceso a la consola de H2Database sin autenticación
			//.anyRequest().authenticated();
			.and()
	        .headers().frameOptions().disable(); // Deshabilitar las restricciones de seguridad de los frames para la consola de H2
	        //.and()
	        //.csrf().ignoringAntMatchers("/h2-console/**"); // Ignorar CSRF para la consola de H2Database
	        /*.and()
	        .formLogin();*/
		
		/*
		http.authorizeRequests()
        .antMatchers("/h2-console/**").permitAll() // Permitir acceso a la consola de H2Database sin autenticación
        .anyRequest().authenticated()
        .and()
        .headers().frameOptions().disable() // Deshabilitar las restricciones de seguridad de los frames para la consola de H2
        .and()
        .csrf().ignoringAntMatchers("/h2-console/**") // Ignorar CSRF para la consola de H2Database
        .and()
        .formLogin();*/
		
	}
}
