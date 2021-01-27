package com.vy.yzc.gateway.filter;

import com.vy.basic.web.handler.JwtInfoHeaderKey;
import com.vy.yzc.gateway.security.AuthorizationManager;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: Edward
 * @Date: 2020/11/13 14:41
 * @Description:
 */
@Log4j2
@Configuration
@AllArgsConstructor
public class JwtHeaderFilter implements GlobalFilter, Ordered {

	private final AuthorizationManager authorizationManager;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		return ReactiveSecurityContextHolder.getContext()
				.filter(c -> c.getAuthentication() != null)
				.map(SecurityContext::getAuthentication)
				.as(authorizationManager::jwtFromAuthentication)
				.map(jwt -> exchange
						.mutate()
						.request(exchange
								.getRequest()
								.mutate()
								.headers(httpHeaders -> httpHeaders.add(JwtInfoHeaderKey.USER_ID_KEY,
										jwt.getClaimAsString(UserAuthenticationConverter.USERNAME)))
								.build())
						.build())
				.flatMap(chain::filter)
				.switchIfEmpty(chain.filter(exchange));
	}

	@Override
	public int getOrder() {
		return Integer.MAX_VALUE;
	}



}
