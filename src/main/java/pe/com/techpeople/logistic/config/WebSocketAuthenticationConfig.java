package pe.com.techpeople.logistic.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Configuration
@EnableWebSocketMessageBroker
@Order(Ordered.HIGHEST_PRECEDENCE + 99)
public class WebSocketAuthenticationConfig implements WebSocketMessageBrokerConfigurer{

	@Value("${app.security.jwt-signing-key}")
    private String signingKey;
	
	 @Override
	    public void configureClientInboundChannel(ChannelRegistration registration) {
	        registration.interceptors(new ChannelInterceptor() {
	            @Override
	            public Message<?> preSend(Message<?> message, MessageChannel channel) {
	                StompHeaderAccessor accessor =
	                        MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
	                if (StompCommand.CONNECT.equals(accessor.getCommand())) {
	                    List<String> authorization = accessor.getNativeHeader("X-Authorization");
	                    System.out.print("authorization "+Arrays.toString(authorization.toArray()));
	                    String accessToken = authorization.get(0).split(" ")[1];

	                    Claims validateToken= validateToken( accessToken);
	                    
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(validateToken, null,
	                    		authorization.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
	                    
	                    accessor.setUser(authentication);
	                }
	                return message;
	            }
	        });
	    }
	 
	 private Claims validateToken(String jwtToken) {
 			return Jwts.parser().setSigningKey(signingKey.getBytes()).parseClaimsJws(jwtToken).getBody();
		}
}
