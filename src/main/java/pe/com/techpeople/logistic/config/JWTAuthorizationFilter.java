package pe.com.techpeople.logistic.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;


public class JWTAuthorizationFilter extends OncePerRequestFilter {
	
	/*@Value("${app.security.jwt-signing-key}")
	private String SECRET;*/
	
	//@Value("${app.security.jwt-signing-key}")
    private String signingKey ;
	


	private final String HEADER = "Authorization";
	private final String PREFIX = "bearer ";
	//private final String SECRET = "mySecretKey";

	public JWTAuthorizationFilter(String signingKey) {
		this.signingKey=signingKey;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		try {
			if (existeJWTToken(request, response)) {
				Claims claims = validateToken(request);
				//if (claims.get("authorities") != null) {
					setUpSpringAuthentication(claims);
				/*} else {
					SecurityContextHolder.clearContext();
				}*/
			} else {
					SecurityContextHolder.clearContext();
			}
			chain.doFilter(request, response);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			System.out.println(request.getContextPath());  
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			return;
		}
	}	

	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		System.out.println("jwtToken "+jwtToken);
		System.out.println("SECRET "+signingKey);

		JwtParser setSigningKey = Jwts.parser().setSigningKey(signingKey.getBytes());
		System.out.println("setSigningKey "+setSigningKey );
		Jws<Claims> parseClaimsJws = setSigningKey.parseClaimsJws(jwtToken);
		System.out.println("parseClaimsJws "+parseClaimsJws );
		return parseClaimsJws.getBody();
	}

	 
	private void setUpSpringAuthentication(Claims claims) {
		/*@SuppressWarnings("unchecked")
		List<String> authorities = (List) claims.get("authorities");*/
		List<String> authorities =autoritiesfromClaim (claims);
		
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);

	}

	private List<String> autoritiesfromClaim(Claims claims){ 
		List<String> authorities = new ArrayList<>();
        Map<String, Object> customClaims = (Map<String, Object>) claims.get("custom_info");
        String nivel = (String) customClaims.get("n");
        if ("1".equals(nivel)) {
            authorities.add("G1");
        }
        Boolean esJefe = (Boolean) customClaims.get("es_jefe");
        if (Boolean.TRUE.equals(esJefe)) {
            authorities.add("jefe");
        }
        
        return authorities;
	}
	
	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		return true;
	}

}