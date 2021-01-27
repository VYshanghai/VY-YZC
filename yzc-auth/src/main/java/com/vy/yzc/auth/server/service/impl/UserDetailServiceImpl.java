package com.vy.yzc.auth.server.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: Edward
 * @Date: 2021/1/27 09:53
 * @Description:
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {


	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 从数据库中获取
		return new User("1111", passwordEncoder.encode("admin"),
				Lists.newArrayList(new SimpleGrantedAuthority("admin")));
	}
}
