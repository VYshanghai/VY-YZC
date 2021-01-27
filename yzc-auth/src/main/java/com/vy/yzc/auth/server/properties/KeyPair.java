package com.vy.yzc.auth.server.properties;

import lombok.Data;

/**
 * @Author: Edward
 * @Date: 2020/11/5 14:01
 * @Description:
 */
@Data
public class KeyPair {

	private String fileName = "yzc.jks";

	private String storePassword = "123456";

	private String keyPassword = "123456";

	private String alias = "yzc";

}
