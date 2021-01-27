package com.vy.yzc.gateway.handler;

import com.alibaba.fastjson.JSON;
import com.vy.basic.web.exception.BaseException;
import com.vy.basic.web.resp.BaseResponse;
import com.vy.basic.web.resp.RespCode;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

/**
 * @Author: Edward
 * @Date: 2020/6/29 18:40
 * @Description:
 */
@Log4j2
public class ErrorAttributes extends DefaultErrorAttributes {

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
		BaseResponse resp = BaseResponse.builder().build();
		Throwable error = getError(request);
		if(log.isErrorEnabled()){
			log.error(error.getMessage(), error);
		}
		HttpStatus httpStatus = determineHttpStatus(error);
		resp.setStatus(httpStatus.value());
		resp.setMessage(determineMessage(error));
		BaseResponse baseResponse = handleException(determineException(error));
		if(HttpStatus.valueOf(baseResponse.getStatus()).isError()){
			resp = baseResponse;
		}
		String respJsonStr = JSON.toJSONString(resp);
		return JSON.parseObject(respJsonStr, Map.class);
	}

	private BaseResponse handleException(Throwable error) {
		BaseResponse baseResponse = BaseResponse.ok();
		if (error instanceof BindingResult) {
			BindingResult errors = (BindingResult) error;
			baseResponse = BaseResponse.error(errors);
		}
		if (error instanceof BaseException) {
			BaseException be = (BaseException) error;
			baseResponse = BaseResponse.error(be);
		}
		if(error instanceof AccessDeniedException){
			baseResponse.setStatus(HttpStatus.FORBIDDEN.value());
			baseResponse.setErrorCode(RespCode.ERROR_403_A0301.getErrorCode());
			baseResponse.setMessage(error.getMessage());
		}
		if(error instanceof AuthenticationException){
			baseResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
			baseResponse.setErrorCode(RespCode.ERROR_401_A0312.getErrorCode());
			baseResponse.setMessage(error.getMessage());
		}
		return baseResponse;
	}
	private HttpStatus determineHttpStatus(Throwable error) {
		if (error instanceof ResponseStatusException) {
			return ((ResponseStatusException) error).getStatus();
		}
		ResponseStatus responseStatus = AnnotatedElementUtils.findMergedAnnotation(error.getClass(),
				ResponseStatus.class);
		if (responseStatus != null) {
			return responseStatus.code();
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	private Throwable determineException(Throwable error) {
		if (error instanceof ResponseStatusException) {
			return (error.getCause() != null) ? error.getCause() : error;
		}
		return error;
	}

	private String determineMessage(Throwable error) {
		if (error instanceof WebExchangeBindException) {
			return error.getMessage();
		}
		if (error instanceof ResponseStatusException) {
			return ((ResponseStatusException) error).getReason();
		}
		ResponseStatus responseStatus = AnnotatedElementUtils.findMergedAnnotation(error.getClass(),
				ResponseStatus.class);
		if (responseStatus != null) {
			return responseStatus.reason();
		}
		return error.getMessage();
	}
}
