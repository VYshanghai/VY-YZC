package com.vy.yzc.auth.server.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vy.yzc.base.po.DefaultMgArgPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@TableName("mg_user")
@EqualsAndHashCode(callSuper = true)
public class MgUser extends DefaultMgArgPO {

	private String username;

	private String password;

	private String mobile;

	private String email;

}
