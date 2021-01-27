package com.vy.yzc.auth.server.config;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: Edward
 * @Date: 2021/1/27 09:57
 * @Description:
 */
public class MgPasswordAuthenticationToken  extends AbstractAuthenticationToken {

	private String userId;

	private String password;

	/**
	 * Creates a token with the supplied array of authorities.
	 *
	 * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal represented by
	 * this authentication object.
	 */
	public MgPasswordAuthenticationToken(
			Collection<? extends GrantedAuthority> authorities, String userId, String password) {
		super(authorities);
		this.userId = userId;
		this.password = password;
	}


	@Override
	public Object getCredentials() {
		return this.password;
	}

	@Override
	public Object getPrincipal() {
		return this.userId;
	}
}
