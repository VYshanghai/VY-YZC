package com.vy.yzc.utils;

import com.alibaba.fastjson.JSON;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.vy.basic.web.exception.BaseException;
import com.vy.basic.web.resp.RespCode;
import java.util.function.Supplier;

/**
 * @Author: Edward
 * @Date: 2020/11/27 18:41
 * @Description:
 */
public class ExecuteTemplate {

	public static <T> T execute(Supplier<HttpResponse<JsonNode>> invoker, Class<T> respClazz)
			throws BaseException {
		HttpResponse<JsonNode> response;
		try {
			response = invoker.get();
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof BaseException) {
				if (((BaseException) e).getStatus() == 404) {
					return null;
				}
			}
			throw new BaseException(RespCode.ERROR_500_B0001);
		}
		if (response.getStatus() < 200 || response.getStatus() > 300) {
			if (response.getStatus() == 404) {
				return null;
			}
			throw new BaseException(response.getStatus(), response.getBody().toString(), "B0500");
		}
		return JSON.parseObject(response.getBody().toString(), respClazz);

	}

}
