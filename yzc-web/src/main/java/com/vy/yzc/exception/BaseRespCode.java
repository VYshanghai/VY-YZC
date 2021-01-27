package com.vy.yzc.exception;

import com.vy.basic.web.resp.RespError;

/**
 * @Author: Edward
 * @Date: 2021/1/25 19:00
 * @Description:
 */
public enum BaseRespCode implements RespError {

	// 基础错误 该错误需要给前端提示
	ERROR_400_A0001 (400,"A0001 ","用户端错误 "),
	ERROR_400_A0100 (400,"A0100 ","用户注册错误 "),
	ERROR_400_A0101 (400,"A0101 ","用户未同意隐私协议 "),
	ERROR_400_A0102 (400,"A0102 ","注册国家或地区受限 "),
	ERROR_400_A0110 (400,"A0110 ","用户名校验失败 "),
	ERROR_400_A0111 (400,"A0111 ","用户名已存在 "),
	ERROR_400_A0112 (400,"A0112 ","用户名包含敏感词 "),
	ERROR_400_A0113 (400,"A0113 ","用户名包含特殊字符 "),
	ERROR_400_A0120 (400,"A0120 ","密码校验失败 "),
	ERROR_400_A0121 (400,"A0121 ","密码长度不够 "),
	ERROR_400_A0122 (400,"A0122 ","密码强度不够 "),
	ERROR_400_A0130 (400,"A0130 ","校验码输入错误 "),
	ERROR_400_A0131 (400,"A0131 ","短信校验码输入错误 "),
	ERROR_400_A0132 (400,"A0132 ","邮件校验码输入错误 "),
	ERROR_400_A0133 (400,"A0133 ","语音校验码输入错误 "),
	ERROR_400_A0140 (400,"A0140 ","用户证件异常 "),
	ERROR_400_A0141 (400,"A0141 ","用户证件类型未选择 "),
	ERROR_400_A0142 (400,"A0142 ","大陆身份证编号校验非法 "),
	ERROR_400_A0143 (400,"A0143 ","护照编号校验非法 "),
	ERROR_400_A0144 (400,"A0144 ","军官证编号校验非法 "),
	ERROR_400_A0150 (400,"A0150 ","用户基本信息校验失败 "),
	ERROR_400_A0151 (400,"A0151 ","手机格式校验失败 "),
	ERROR_400_A0152 (400,"A0152 ","地址格式校验失败 "),
	ERROR_400_A0153 (400,"A0153 ","邮箱格式校验失败 "),
	ERROR_400_A0200 (400,"A0200 ","用户登陆异常 "),
	ERROR_400_A0201 (400,"A0201 ","用户账户不存在 "),
	ERROR_400_A0202 (400,"A0202 ","用户账户被冻结 "),
	ERROR_400_A0203 (400,"A0203 ","用户账户已作废 "),
	ERROR_400_A0210 (400,"A0210 ","用户密码错误 "),
	ERROR_400_A0211 (400,"A0211 ","用户输入密码次数超限 "),
	ERROR_400_A0220 (400,"A0220 ","用户身份校验失败 "),
	ERROR_400_A0221 (400,"A0221 ","用户指纹识别失败 "),
	ERROR_400_A0222 (400,"A0222 ","用户面容识别失败 "),
	ERROR_400_A0223 (400,"A0223 ","用户未获得第三方登陆授权 "),
	ERROR_400_A0230 (400,"A0230 ","用户登陆已过期 "),
	ERROR_400_A0240 (400,"A0240 ","用户验证码错误 "),
	ERROR_400_A0241 (400,"A0241 ","用户验证码尝试次数超限 "),
	ERROR_400_A0300 (400,"A0300 ","访问权限异常 "),
	ERROR_400_A0301 (400,"A0301 ","访问未授权 "),
	ERROR_400_A0302 (400,"A0302 ","正在授权中 "),
	ERROR_400_A0303 (400,"A0303 ","用户授权申请被拒绝 "),
	ERROR_400_A0310 (400,"A0310 ","因访问对象隐私设置被拦截 "),
	ERROR_400_A0311 (400,"A0311 ","授权已过期 "),
	ERROR_400_A0312 (400,"A0312 ","无权限使用 API "),
	ERROR_400_A0320 (400,"A0320 ","用户访问被拦截 "),
	ERROR_400_A0321 (400,"A0321 ","黑名单用户 "),
	ERROR_400_A0322 (400,"A0322 ","账号被冻结 "),
	ERROR_400_A0323 (400,"A0323 ","非法 IP 地址 "),
	ERROR_400_A0324 (400,"A0324 ","网关访问受限 "),
	ERROR_400_A0325 (400,"A0325 ","地域黑名单 "),
	ERROR_400_A0330 (400,"A0330 ","服务已欠费 "),
	ERROR_400_A0340 (400,"A0340 ","用户签名异常 "),
	ERROR_400_A0341 (400,"A0341 ","RSA 签名错误 "),
	ERROR_400_A0400 (400,"A0400 ","用户请求参数错误 "),
	ERROR_400_A0401 (400,"A0401 ","包含非法恶意跳转链接 "),
	ERROR_400_A0402 (400,"A0402 ","无效的用户输入 "),
	ERROR_400_A0410 (400,"A0410 ","请求必填参数为空 "),
	ERROR_400_A0411 (400,"A0411 ","用户订单号为空 "),
	ERROR_400_A0412 (400,"A0412 ","订购数量为空 "),
	ERROR_400_A0413 (400,"A0413 ","缺少时间戳参数 "),
	ERROR_400_A0414 (400,"A0414 ","非法的时间戳参数 "),
	ERROR_400_A0420 (400,"A0420 ","请求参数值超出允许的范围 "),
	ERROR_400_A0421 (400,"A0421 ","参数格式不匹配 "),
	ERROR_400_A0422 (400,"A0422 ","地址不在服务范围 "),
	ERROR_400_A0423 (400,"A0423 ","时间不在服务范围 "),
	ERROR_400_A0424 (400,"A0424 ","金额超出限制 "),
	ERROR_400_A0425 (400,"A0425 ","数量超出限制 "),
	ERROR_400_A0426 (400,"A0426 ","请求批量处理总个数超出限制 "),
	ERROR_400_A0427 (400,"A0427 ","请求 JSON 解析失败 "),
	ERROR_400_A0430 (400,"A0430 ","用户输入内容非法 "),
	ERROR_400_A0431 (400,"A0431 ","包含违禁敏感词 "),
	ERROR_400_A0432 (400,"A0432 ","图片包含违禁信息 "),
	ERROR_400_A0433 (400,"A0433 ","文件侵犯版权 "),
	ERROR_400_A0440 (400,"A0440 ","用户操作异常 "),
	ERROR_400_A0441 (400,"A0441 ","用户支付超时 "),
	ERROR_400_A0442 (400,"A0442 ","确认订单超时 "),
	ERROR_400_A0443 (400,"A0443 ","订单已关闭 "),
	ERROR_400_A0500 (400,"A0500 ","用户请求服务异常 "),
	ERROR_400_A0501 (400,"A0501 ","请求次数超出限制 "),
	ERROR_400_A0502 (400,"A0502 ","请求并发数超出限制 "),
	ERROR_400_A0503 (400,"A0503 ","用户操作请等待 "),
	ERROR_400_A0504 (400,"A0504 ","WebSocket 连接异常 "),
	ERROR_400_A0505 (400,"A0505 ","WebSocket 连接断开 "),
	ERROR_400_A0506 (400,"A0506 ","用户重复请求 "),
	ERROR_400_A0600 (400,"A0600 ","用户资源异常 "),
	ERROR_400_A0601 (400,"A0601 ","账户余额不足 "),
	ERROR_400_A0602 (400,"A0602 ","用户磁盘空间不足 "),
	ERROR_400_A0603 (400,"A0603 ","用户内存空间不足 "),
	ERROR_400_A0604 (400,"A0604 ","用户 OSS 容量不足 "),
	ERROR_400_A0605 (400,"A0605 ","用户配额已用光 "),
	ERROR_400_A0700 (400,"A0700 ","用户上传文件异常 "),
	ERROR_400_A0701 (400,"A0701 ","用户上传文件类型不匹配 "),
	ERROR_400_A0702 (400,"A0702 ","用户上传文件太大 "),
	ERROR_400_A0703 (400,"A0703 ","用户上传图片太大 "),
	ERROR_400_A0704 (400,"A0704 ","用户上传视频太大 "),
	ERROR_400_A0705 (400,"A0705 ","用户上传压缩文件太大 "),
	ERROR_400_A0800 (400,"A0800 ","用户当前版本异常 "),
	ERROR_400_A0801 (400,"A0801 ","用户安装版本与系统不匹配 "),
	ERROR_400_A0802 (400,"A0802 ","用户安装版本过低 "),
	ERROR_400_A0803 (400,"A0803 ","用户安装版本过高 "),
	ERROR_400_A0804 (400,"A0804 ","用户安装版本已过期 "),
	ERROR_400_A0805 (400,"A0805 ","用户 API 请求版本不匹配 "),
	ERROR_400_A0806 (400,"A0806 ","用户 API 请求版本过高 "),
	ERROR_400_A0807 (400,"A0807 ","用户 API 请求版本过低 "),
	ERROR_400_A0900 (400,"A0900 ","用户隐私未授权 "),
	ERROR_400_A0901 (400,"A0901 ","用户隐私未签署 "),
	ERROR_400_A0902 (400,"A0902 ","用户摄像头未授权 "),
	ERROR_400_A0903 (400,"A0903 ","用户相机未授权 "),
	ERROR_400_A0904 (400,"A0904 ","用户图片库未授权 "),
	ERROR_400_A0905 (400,"A0905 ","用户文件未授权 "),
	ERROR_400_A0906 (400,"A0906 ","用户位置信息未授权 "),
	ERROR_400_A0907 (400,"A0907 ","用户通讯录未授权 "),
	ERROR_400_A1000 (400,"A1000 ","用户设备异常 "),
	ERROR_400_A1001 (400,"A1001 ","用户相机异常 "),
	ERROR_400_A1002 (400,"A1002 ","用户麦克风异常 "),
	ERROR_400_A1003 (400,"A1003 ","用户听筒异常 "),
	ERROR_400_A1004 (400,"A1004 ","用户扬声器异常 "),
	ERROR_400_A1005 (400,"A1005 ","用户 GPS 定位异常 "),

	// 系统错误 该异常在上线前 需要全部解决
	ERROR_500_B0001 (500,"B0001 ","系统执行出错 "),
	ERROR_500_B0100 (500,"B0100 ","系统执行超时 "),
	ERROR_500_B0101 (500,"B0101 ","系统订单处理超时 "),
	ERROR_500_B0200 (500,"B0200 ","系统容灾功能被触发 "),
	ERROR_500_B0210 (500,"B0210 ","系统限流 "),
	ERROR_500_B0220 (500,"B0220 ","系统功能降级 "),
	ERROR_500_B0300 (500,"B0300 ","系统资源异常 "),
	ERROR_500_B0310 (500,"B0310 ","系统资源耗尽 "),
	ERROR_500_B0311 (500,"B0311 ","系统磁盘空间耗尽 "),
	ERROR_500_B0312 (500,"B0312 ","系统内存耗尽 "),
	ERROR_500_B0313 (500,"B0313 ","文件句柄耗尽 "),
	ERROR_500_B0314 (500,"B0314 ","系统连接池耗尽 "),
	ERROR_500_B0315 (500,"B0315 ","系统线程池耗尽 "),
	ERROR_500_B0320 (500,"B0320 ","系统资源访问异常 "),
	ERROR_500_B0321 (500,"B0321 ","系统读取磁盘文件失败 "),

	// 该类错误属于中间件错误酌情处理
	ERROR_500_C0001 (500,"C0001 ","调用第三方服务出错 "),
	ERROR_500_C0100 (500,"C0100 ","中间件服务出错 "),
	ERROR_500_C0110 (500,"C0110 ","RPC 服务出错 "),
	ERROR_500_C0111 (500,"C0111 ","RPC 服务未找到 "),
	ERROR_500_C0112 (500,"C0112 ","RPC 服务未注册 "),
	ERROR_500_C0113 (500,"C0113 ","接口不存在 "),
	ERROR_500_C0120 (500,"C0120 ","消息服务出错 "),
	ERROR_500_C0121 (500,"C0121 ","消息投递出错 "),
	ERROR_500_C0122 (500,"C0122 ","消息消费出错 "),
	ERROR_500_C0123 (500,"C0123 ","消息订阅出错 "),
	ERROR_500_C0124 (500,"C0124 ","消息分组未查到 "),
	ERROR_500_C0130 (500,"C0130 ","缓存服务出错 "),
	ERROR_500_C0131 (500,"C0131 ","key 长度超过限制 "),
	ERROR_500_C0132 (500,"C0132 ","value 长度超过限制 "),
	ERROR_500_C0133 (500,"C0133 ","存储容量已满 "),
	ERROR_500_C0134 (500,"C0134 ","不支持的数据格式 "),
	ERROR_500_C0140 (500,"C0140 ","配置服务出错 "),
	ERROR_500_C0150 (500,"C0150 ","网络资源服务出错 "),
	ERROR_500_C0151 (500,"C0151 ","VPN 服务出错 "),
	ERROR_500_C0152 (500,"C0152 ","CDN 服务出错 "),
	ERROR_500_C0153 (500,"C0153 ","域名解析服务出错 "),
	ERROR_500_C0154 (500,"C0154 ","网关服务出错 "),
	ERROR_500_C0200 (500,"C0200 ","第三方系统执行超时 "),
	ERROR_500_C0210 (500,"C0210 ","RPC 执行超时 "),
	ERROR_500_C0220 (500,"C0220 ","消息投递超时 "),
	ERROR_500_C0230 (500,"C0230 ","缓存服务超时 "),
	ERROR_500_C0240 (500,"C0240 ","配置服务超时 "),
	ERROR_500_C0250 (500,"C0250 ","数据库服务超时 "),
	ERROR_500_C0300 (500,"C0300 ","数据库服务出错 "),
	ERROR_500_C0311 (500,"C0311 ","表不存在 "),
	ERROR_500_C0312 (500,"C0312 ","列不存在 "),
	ERROR_500_C0321 (500,"C0321 ","多表关联中存在多个相同名称的列 "),
	ERROR_500_C0331 (500,"C0331 ","数据库死锁 "),
	ERROR_500_C0341 (500,"C0341 ","主键冲突 "),
	ERROR_500_C0400 (500,"C0400 ","第三方容灾系统被触发 "),
	ERROR_500_C0401 (500,"C0401 ","第三方系统限流 "),
	ERROR_500_C0402 (500,"C0402 ","第三方功能降级 "),
	ERROR_500_C0500 (500,"C0500 ","通知服务出错 "),
	ERROR_500_C0501 (500,"C0501 ","短信提醒服务失败 "),
	ERROR_500_C0502 (500,"C0502 ","语音提醒服务失败 "),
	ERROR_500_C0503 (500,"C0503 ","邮件提醒服务失败 "),


	;

	int status;

	String errorCode;

	String message;

	BaseRespCode(int status, String errorCode, String message) {
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
	}

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
