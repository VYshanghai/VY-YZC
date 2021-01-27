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
 * @Date: 2021/1/25 20:14
 * @Description: 微信小程序授权模式
 */
public class VXMiniProgramGranter extends AbstractTokenGranter {

	public static final String GRANT_TYPE = "vx-mini-program";

	public VXMiniProgramGranter(
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
		//TODO  鉴权。 生成token
		// 通过 code 调用 third 服务 -> 访问微信开放管理平台, 通过appId appsecret code 获取 用户 session_key 和 openId
		// 保存用户 openId 如果用户未注册小程序时，需创建用户
		// 生成oauth2认证信息
		return new OAuth2Authentication(storedOAuth2Request, new VXMiniProgramAuthenticationToken(
				Lists.newArrayList(new SimpleGrantedAuthority("APP_USER")), requestParameters.get("mobile"),
				requestParameters.get("code")));
	}
}
