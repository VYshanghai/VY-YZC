package com.vy.yzc.eureka;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author vikko
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer
@Log4j2
public class EurekaBootstrap {

    public static void main(String... args) {
        SpringApplication.run(EurekaBootstrap.class, args);
        log.info(
            "\n\n--------------------   YZC 微服务模块：vy-yzc-eureka 注册成功!    --------------------\n");
    }


}

