package com.vy.yzc.gateway.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @Author: Edward
 * @Date: 2020/11/18 14:53
 * @Description:
 */
@Component
@AllArgsConstructor
public class AuthorizationManager implements
		ReactiveAuthorizationManager<AuthorizationContext> {

	@Override
	public Mono<AuthorizationDecision> check(Mono<Authentication> authentication,
			AuthorizationContext object) {
		return authentication.map(a -> {
			ReactiveSecurityContextHolder.withAuthentication(a);
			return a;
		}).as(this::jwtFromAuthentication)
				.map(jwt -> jwt.getClaimAsString(AccessTokenConverter.CLIENT_ID))
				.as(client -> client
						.map(id -> new AuthorizationDecision(true))) // TODO 此处先默认设置为true 具体情况之后再定
				.defaultIfEmpty(new AuthorizationDecision(false));
	}

	public Mono<Jwt> jwtFromAuthentication(Mono<Authentication> authentication) {
		return authentication.filter(a -> a instanceof JwtAuthenticationToken)
				.cast(JwtAuthenticationToken.class)
				.map(AbstractAuthenticationToken::getPrincipal)
				.filter(principal -> principal instanceof Jwt)
				.cast(Jwt.class);
	}
}
