package com.vy.yzc.gateway.handler;

import com.vy.yzc.gateway.properties.Swagger2Properties;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @Author: Edward
 * @Date: 2020/7/1 19:05
 * @Description:
 */
@Component
@Primary
@AllArgsConstructor
public class SwaggerProvider implements SwaggerResourcesProvider {

	private final Swagger2Properties swagger2Properties;

	private final RouteLocator routeLocator;

	private final GatewayProperties gatewayProperties;

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		List<String> routes = new ArrayList<>();
		routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
		gatewayProperties.getRoutes().stream()
				.filter(routeDefinition -> routes.contains(routeDefinition.getId()))
				.forEach(routeDefinition -> {
					List<Boolean> swagger2HeaderFilter = routeDefinition.getFilters().stream()
							.filter(filterDefinition -> filterDefinition.getName()
									.equals(swagger2Properties.getFilter()))
							.map(filterDefinition -> true).collect(Collectors.toList());
					if (swagger2HeaderFilter.size() > 0) {
						routeDefinition.getPredicates().stream()
								.filter(
										predicateDefinition -> (swagger2Properties.getPredicate())
												.equalsIgnoreCase(predicateDefinition.getName()))
								.forEach(predicateDefinition -> resources
										.add(swaggerResource(routeDefinition.getId(), predicateDefinition.getArgs()
												.get(NameUtils.generateName(swagger2Properties.getGeneratedNamePrefix()))
												.replace(swagger2Properties.getReplaceTarget(), swagger2Properties.getDocApi()))));
					}
				});
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(swagger2Properties.getVersion());
		return swaggerResource;
	}

}
