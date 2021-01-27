package com.vy.yzc.gateway.filter;

import com.vy.yzc.gateway.properties.Swagger2Properties;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * @Author: Edward
 * @Date: 2020/7/1 19:33
 * @Description: @Deprecated 当前版本spring cloud gateway 默认 添加这个头部
 * @see org.springframework.cloud.gateway.filter.headers.XForwardedHeadersFilter
 */
@Component
@AllArgsConstructor
public class Swagger2HeaderFilter extends AbstractGatewayFilterFactory {

	private final Swagger2Properties swagger2Properties;


	@Override
	public GatewayFilter apply(Object config) {
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			String path = request.getURI().getPath();
			if (StringUtils.endsWithIgnoreCase(path, swagger2Properties.getDocApi())) {
				return chain.filter(exchange);
			}
			ServerWebExchange newExchange = exchange.mutate().request(request.mutate().build()).build();
			return chain.filter(newExchange);
		};
	}
}
