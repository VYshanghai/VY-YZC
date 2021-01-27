package com.vy.yzc.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Edward
 * @Date: 2020/7/1 19:19
 * @Description:
 */
@Data
@Component
@ConfigurationProperties("swagger2")
public class Swagger2Properties {

	private String docApi;

	private String version;

	private String filter;

	private Integer generatedNamePrefix;

	private String replaceTarget;

	private String predicate;

}
