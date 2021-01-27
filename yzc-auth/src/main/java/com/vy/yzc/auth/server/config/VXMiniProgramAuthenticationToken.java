package com.vy.yzc.auth.server.config;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: Edward
 * @Date: 2021/1/25 20:17
 * @Description: 鉴权 token 对象
 */
public class VXMiniProgramAuthenticationToken extends AbstractAuthenticationToken {

	private String userId;

	private String code;

	/**
	 * Creates a token with the supplied array of authorities.
	 *
	 * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal represented by
	 * this authentication object.
	 */
	public VXMiniProgramAuthenticationToken(
			Collection<? extends GrantedAuthority> authorities, String userId, String code) {
		super(authorities);
		this.userId = userId;
		this.code = code;
	}


	@Override
	public Object getCredentials() {
		return this.code;
	}

	@Override
	public Object getPrincipal() {
		return this.userId;
	}
}
