package com.vy.yzc.auth.server;

import com.vy.basic.redis.EnableRedisConfig;
import com.vy.basic.web.EnableVYSwagger2;
import com.vy.yzc.config.EnableYZCWeb;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Edward
 * @Date: 2021/1/25 19:36
 * @Description: 羊植厂认证服务启动类
 */
@Log4j2
@EnableYZCWeb
@EnableVYSwagger2
@EnableRedisConfig
@SpringBootApplication
@EnableEurekaClient
public class AuthServerBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerBootstrap.class, args);
		log.info("\n\n--------------------   Visva YZC 模块：yzc-auth 注册成功!    --------------------\n");
	}

}
