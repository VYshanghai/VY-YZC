package com.vy.yzc.gateway.config;

import com.vy.yzc.gateway.handler.ErrorAttributes;
import com.vy.yzc.gateway.handler.WebFluxExceptionHandler;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;


/**
 * @Author: Edward
 * @Date: 2020/6/29 18:45
 * @Description:
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties({ServerProperties.class, ResourceProperties.class})
public class WebFluxErrorConfiguration {

	private final ServerProperties serverProperties;

	private final ApplicationContext applicationContext;

	private final ResourceProperties resourceProperties;

	private final List<ViewResolver> viewResolvers;

	private final ServerCodecConfigurer serverCodecConfigurer;

	@Bean
	public ErrorWebExceptionHandler errorWebExceptionHandler() {
		DefaultErrorWebExceptionHandler exceptionHandler = new WebFluxExceptionHandler(
				errorAttributes(),
				this.resourceProperties, this.serverProperties.getError(), this.applicationContext);
		exceptionHandler.setViewResolvers(this.viewResolvers);
		exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
		exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
		return exceptionHandler;
	}

	@Bean
	public DefaultErrorAttributes errorAttributes() {
		return new ErrorAttributes();
	}


}
