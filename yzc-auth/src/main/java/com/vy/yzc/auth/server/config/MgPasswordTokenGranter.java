package com.vy.yzc.auth.server.config;

import com.google.common.collect.Lists;
import java.util.Map;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

/**
 * @Author: Edward
 * @Date: 2021/1/27 09:55
 * @Description:
 */
public class MgPasswordTokenGranter extends AbstractTokenGranter {


	public static final String GRANT_TYPE = "mg_pwd";

	public MgPasswordTokenGranter(
			AuthorizationServerTokenServices tokenServices,
			ClientDetailsService clientDetailsService,
			OAuth2RequestFactory requestFactory) {
		super(tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
	}

	@Override
	protected OAuth2Authentication getOAuth2Authentication(ClientDetails client,
			TokenRequest tokenRequest) {
		Map<String, String> requestParameters = tokenRequest.getRequestParameters();
		OAuth2Request storedOAuth2Request = getRequestFactory()
				.createOAuth2Request(client, tokenRequest);
		String username = requestParameters.get("username");
		String password = requestParameters.get("password");
		//TODO 验证 password 的合法性
		// 查询用户Id

		return new OAuth2Authentication(storedOAuth2Request, new MgPasswordAuthenticationToken(Lists.newArrayList(new SimpleGrantedAuthority("")), "", ""));
	}
}
