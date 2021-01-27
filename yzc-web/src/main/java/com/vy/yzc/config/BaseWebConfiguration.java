package com.vy.yzc.config;

import com.vy.basic.redis.util.RedisUtil;
import com.vy.basic.web.config.WebMvcConfiguration;
import com.vy.yzc.interceptor.HeadInfoInterceptor;
import com.vy.yzc.interceptor.RepeatReqCheckInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @Author: Edward
 * @Date: 2020/11/30 16:00
 * @Description:
 */

@AllArgsConstructor
public class BaseWebConfiguration extends WebMvcConfiguration {

	private final RedisUtil redisUtil;

	@Bean
	public RepeatReqCheckInterceptor repeatReqCheckInterceptor() {
		return new RepeatReqCheckInterceptor(redisUtil);
	}

	@Bean
	public HeadInfoInterceptor headInfoInterceptor() {
		return new HeadInfoInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(repeatReqCheckInterceptor()).addPathPatterns(allPath())
				.excludePathPatterns(providerPath());
		registry.addInterceptor(headInfoInterceptor()).addPathPatterns(allPath())
				.excludePathPatterns(providerPath());
	}

	private String allPath() {
		return "/**";
	}

	private String providerPath() {
		return "/provider/**";
	}

}
