package com.vy.yzc.gateway.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Edward
 * @Date: 2020/6/22 10:33
 * @Description:
 */
@Configuration
public class RoutConfiguration {

	@Bean
	public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(
			DiscoveryClient discoveryClient, DiscoveryLocatorProperties discoveryLocatorProperties) {
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, discoveryLocatorProperties);
	}
}
