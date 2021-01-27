package com.vy.yzc.gateway.handler;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

/**
 * @Author: Edward
 * @Date: 2020/7/1 19:03
 * @Description:
 */
@Component
@RequestMapping("/swagger-resources")
public class SwaggerHandler {

	@Autowired(required = false)
	private  SecurityConfiguration securityConfiguration;

	@Autowired(required = false)
	private  UiConfiguration uiConfiguration;

	@Autowired(required = false)
	private  SwaggerResourcesProvider swaggerResources;


	@RequestMapping(value = "/configuration/security")
	@ResponseBody
	public ResponseEntity<SecurityConfiguration> securityConfiguration() {
		return ResponseEntity.ok(
				Optional.ofNullable(securityConfiguration).orElse(SecurityConfigurationBuilder.builder().build()));
	}

	@RequestMapping(value = "/configuration/ui")
	@ResponseBody
	public ResponseEntity<UiConfiguration> uiConfiguration() {
		return ResponseEntity.ok(Optional.ofNullable(uiConfiguration).orElse(UiConfigurationBuilder.builder().build()));
	}

	@RequestMapping(value = "")
	@ResponseBody
	public ResponseEntity<List<SwaggerResource>> swaggerResources() {
		return ResponseEntity.ok(swaggerResources.get());
	}
}
