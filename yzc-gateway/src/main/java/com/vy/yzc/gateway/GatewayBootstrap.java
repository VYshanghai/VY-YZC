package com.vy.yzc.gateway;

import com.vy.basic.web.utils.SpringContextUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @Author: Edward
 * @Date: 2020/11/4 18:59
 * @Description:
 */
@Log4j2
@EnableEurekaClient
@SpringBootApplication
@Import(SpringContextUtil.class)
@EnableFeignClients()
public class GatewayBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(GatewayBootstrap.class, args);
		log.info(
				"\n\n--------------------   Visva YZC 模块：vy-yzc-gateway 注册成功!    --------------------\n");
	}

}
