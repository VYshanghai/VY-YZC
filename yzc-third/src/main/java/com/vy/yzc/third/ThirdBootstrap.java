package com.vy.yzc.third;

import com.vy.basic.elasticsearch.EnableElasticsearchConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Edward
 * @Date: 2021/2/1 10:21
 * @Description:
 */

@SpringBootApplication
@EnableElasticsearchConfig
@Slf4j
public class ThirdBootstrap {
	public static void main(String[] args) {

		SpringApplication.run(ThirdBootstrap.class, args);
		log.info(
				"\n\n--------------------   Visva-yzc 微服务模块：vy-yac-third 注册成功!    --------------------\n");

	}
}
