package com.vy.yzc.auth.server.properties;

import com.google.common.collect.Lists;
import com.vy.yzc.auth.server.config.VXMiniProgramGranter;
import java.util.List;
import lombok.Data;

/**
 * @Author: Edward
 * @Date: 2020/11/4 16:25
 * @Description:
 */
@Data
public class YZCClient {

	private Boolean enable = Boolean.FALSE;

	private String id = "yzc-mini-program";

	private String secret = "$apr1$vy$ko7YGOqtM7ko7TTdv/dCM.";

	private List<String> scope = Lists.newArrayList("select");

	private List<String> grant_type = Lists.newArrayList(VXMiniProgramGranter.GRANT_TYPE);

	private List<String> authorities  = Lists.newArrayList("client");

	// token 有效时长
	private Integer validateAccessTokenExpire = 60 * 60 * 24 * 100;

}
