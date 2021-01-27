package com.vy.yzc.interceptor;

import com.vy.basic.redis.util.RedisUtil;
import com.vy.basic.web.exception.BaseException;
import com.vy.basic.web.handler.BaseContextHandler;
import com.vy.yzc.exception.BaseRespCode;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @Author: Edward
 * @Date: 2020/11/30 14:58
 * @Description:
 */
@AllArgsConstructor
public class RepeatReqCheckInterceptor extends HandlerInterceptorAdapter {

	private final RedisUtil redisUtil;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			RepeatRequestCheck annotation = method.getAnnotation(RepeatRequestCheck.class);
			if (annotation != null) {
				String api = annotation.api();
				Long userId = BaseContextHandler.getUserId();
				if (Objects.isNull(userId) || -1L == userId) {
					return true;
				}
				String repeatKey = api + userId;
				boolean success = redisUtil.set(repeatKey, "1", true, 30, TimeUnit.SECONDS);
				if(!success){
					throw new BaseException(BaseRespCode.ERROR_400_A0501);
				}
				return true;
			}
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			RepeatRequestCheck annotation = method.getAnnotation(RepeatRequestCheck.class);
			if (Objects.nonNull(annotation)) {
				String api = annotation.api();
				Long userId = BaseContextHandler.getUserId();
				String repeatKey = api + userId;
				if (Objects.nonNull(userId) && -1L != userId) {
					redisUtil.del(repeatKey);
				}
			}
		}
		super.afterCompletion(request, response, handler, ex);
	}
}
