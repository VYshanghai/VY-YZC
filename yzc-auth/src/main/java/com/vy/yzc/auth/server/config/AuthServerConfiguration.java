package com.vy.yzc.auth.server.config;

import com.vy.yzc.auth.server.properties.OAuth2Properties;
import com.vy.yzc.auth.server.service.impl.ClientServiceImpl;
import java.security.KeyPair;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * @Author: Edward
 * @Date: 2020/6/18 10:55
 * @Description:
 */
@Log4j2
@Configuration
@AllArgsConstructor
@EnableAuthorizationServer
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	private final ClientServiceImpl clientDetailsService;

	private final AuthenticationManager authenticationManager;

	private final UserDetailsService userDetailsService;

	private final TokenStore tokenStore;

	private final OAuth2Properties oAuth2Properties;


	/**
	 * @param clients 客户 置器
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetailsService).build();
	}

	/**
	 * @param security 认证服务安全配置器
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients().passwordEncoder(passwordEncoder);
		security.checkTokenAccess("permitAll()");
	}

	/**
	 * @param endpoints 认证服务接口相关配置
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints
//				.tokenServices()
				// 设置身份认证管理器
				.authenticationManager(authenticationManager)
				//设置用户信息查询业务类
				.userDetailsService(userDetailsService)
				//设置token存储方式
				.tokenStore(tokenStore)
				//设置token转化器
				.accessTokenConverter(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyPair());
		log.info(":>>> jwtAccessTokenConverter with {$converter}:{}", converter.toString());
		return converter;
	}

	@Bean
	public KeyPair keyPair() {
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
				new ClassPathResource(oAuth2Properties.getKeyPair().getFileName()),
				oAuth2Properties.getKeyPair().getKeyPassword().toCharArray());
		return keyStoreKeyFactory.getKeyPair(oAuth2Properties.getKeyPair().getAlias(),
				oAuth2Properties.getKeyPair().getStorePassword().toCharArray());
	}

}
