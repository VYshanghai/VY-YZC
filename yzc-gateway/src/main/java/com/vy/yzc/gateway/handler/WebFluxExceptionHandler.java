package com.vy.yzc.gateway.handler;

import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.server.ServerRequest;

/**
 * @Author: Edward
 * @Date: 2020/6/29 17:15
 * @Description:
 */
@Log4j2
public class WebFluxExceptionHandler extends DefaultErrorWebExceptionHandler {


	/**
	 * Create a new {@code DefaultErrorWebExceptionHandler} instance.
	 *
	 * @param errorAttributes the error attributes
	 * @param resourceProperties the resources configuration properties
	 * @param errorProperties the error configuration properties
	 * @param applicationContext the current application context
	 */
	public WebFluxExceptionHandler(
			ErrorAttributes errorAttributes,
			ResourceProperties resourceProperties,
			ErrorProperties errorProperties,
			ApplicationContext applicationContext) {
		super(errorAttributes, resourceProperties, errorProperties, applicationContext);
	}


	@Override
	protected Map<String, Object> getErrorAttributes(ServerRequest request,
			boolean includeStackTrace) {
		return super.getErrorAttributes(request, includeStackTrace);
	}

}
