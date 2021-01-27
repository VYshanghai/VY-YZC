package com.vy.yzc.auth.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: Edward
 * @Date: 2021/1/27 10:55
 * @Description:
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class AppUser {

	private Long id;

	private String vxOpenId;

	private String mobile;

	private String account;

	private String password;

}
