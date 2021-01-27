package com.vy.yzc.gateway.config;

import com.vy.yzc.gateway.properties.OAuth2Properties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Created by Edward on 2020/06/27.
 */
@AllArgsConstructor
@EnableWebFluxSecurity
public class ResourceServerConfigurer {


	private final OAuth2Properties oAuth2Properties;

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.httpBasic().disable()
				.csrf().disable()
				.authorizeExchange()
				.pathMatchers(oAuth2Properties.getIgnoreUri().toArray(new String[]{})).permitAll()
				// 授权
				.anyExchange().authenticated()
				.and().oauth2ResourceServer().jwt(); // 用于做 JWT Token 解析及校验
		return http.build();
	}
}
