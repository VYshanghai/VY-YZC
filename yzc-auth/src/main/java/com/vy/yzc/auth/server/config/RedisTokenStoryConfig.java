package com.vy.yzc.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Author: Edward
 * @Date: 2020/11/4 16:09
 * @Description:
 */
@Configuration
public class RedisTokenStoryConfig {

	private final RedisConnectionFactory redisConnectionFactory;

	public RedisTokenStoryConfig(
			RedisConnectionFactory redisConnectionFactory) {
		this.redisConnectionFactory = redisConnectionFactory;
	}

	@Bean
	public TokenStore redisTokenStore (){
		return new RedisTokenStore(redisConnectionFactory);
	}
}
