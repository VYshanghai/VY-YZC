package com.vy.yzc.auth.server.service.impl;

import com.google.common.collect.Lists;
import com.vy.yzc.auth.server.properties.OAuth2Properties;
import com.vy.yzc.auth.server.properties.YZCClient;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * @Author: Edward
 * @Date: 2020/11/4 16:22
 * @Description:
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientDetailsService {

	private final PasswordEncoder passwordEncoder;

	private final OAuth2Properties oAuth2Properties;


	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		// TODO 从数据库中获取
		YZCClient yzcClient = oAuth2Properties.getYZCClient();
		if (Objects.nonNull(yzcClient)) {
			if (yzcClient.getEnable()) {
				if (yzcClient.getId().equals(clientId)) {
					BaseClientDetails clientDetails = new BaseClientDetails();
					clientDetails.setAccessTokenValiditySeconds(yzcClient.getValidateAccessTokenExpire());
					clientDetails.setClientId(clientId);
					clientDetails.setScope(yzcClient.getScope());
					clientDetails.setResourceIds(Lists.newArrayList("org.springframework.security.oauth2-resource"));
					clientDetails.setAuthorizedGrantTypes(yzcClient.getGrant_type());
					clientDetails.setAuthorities(yzcClient.getAuthorities().stream()
							.map(a -> (GrantedAuthority) () -> a).collect(Collectors.toList()));
					clientDetails.setClientSecret(passwordEncoder.encode(yzcClient.getSecret()));
					return clientDetails;
				}
			}
		}
		return new BaseClientDetails();
	}
}
