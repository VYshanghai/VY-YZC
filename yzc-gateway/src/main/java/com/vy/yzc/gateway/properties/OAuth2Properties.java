package com.vy.yzc.gateway.properties;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Edward
 * @Date: 2020/6/24 18:09
 * @Description:
 */
@Data
@Component
@ConfigurationProperties("oauth2")
public class OAuth2Properties {

	private List<String> ignoreUri = Lists.newArrayList("/**");


}
