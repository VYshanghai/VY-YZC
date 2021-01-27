package com.vy.yzc.interceptor;

import com.vy.yzc.common.constants.HeadInfoContextHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @Author: Edward
 * @Date: 2020/12/15 15:59
 * @Description:
 */
public class HeadInfoInterceptor extends HandlerInterceptorAdapter {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String platform = request.getHeader(HeadInfoContextHandler.platform);
		HeadInfoContextHandler.setPlatform(platform);
		String version = request.getHeader(HeadInfoContextHandler.version);
		HeadInfoContextHandler.setVersion(version);
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
		HeadInfoContextHandler.remove();
		super.afterCompletion(request, response, handler, ex);
	}
}
