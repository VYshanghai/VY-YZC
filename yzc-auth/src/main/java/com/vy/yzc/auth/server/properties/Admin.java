package com.vy.yzc.auth.server.properties;

import lombok.Data;

/**
 * @Author: Edward
 * @Date: 2020/7/7 11:52
 * @Description:
 */
@Data
public class Admin {

	private Boolean enable = Boolean.FALSE;

	private String username = "admin";

	private String password = "admin";

	private String role = "ROLE_SYS";

}
