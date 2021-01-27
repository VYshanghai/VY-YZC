package com.vy.yzc.gateway.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import com.vy.basic.web.exception.BaseException;
import com.vy.basic.web.resp.BaseResponse;
import com.vy.basic.web.resp.RespCode;
import com.vy.basic.web.resp.RestResponse;
import java.util.Objects;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

/**
 * @Author: Edward
 * @Date: 2020/6/29 21:00
 * @Description: TODO 还需要添加更多的异常处理 参照 com.vy.basic.web.handler.GlobalExceptionHandler
 */
@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandlers {

	@ResponseStatus(BAD_REQUEST)
	@ExceptionHandler({WebExchangeBindException.class})
	protected ResponseEntity<Object> webExchangeBindException(
			@Nullable WebExchangeBindException ex, @Nullable HttpStatus status) {
		if (Objects.isNull(ex)) {
			return null;
		}
		if (status == null) {
			status = BAD_REQUEST;
		}
		log.error("WebExchangeBindException msg:{}",ex.getMessage());
		return ResponseEntity.status(status).body(RestResponse.error(ex.getBindingResult()));
	}

	@ResponseStatus(FORBIDDEN)
	@ExceptionHandler({AccessDeniedException.class})
	public BaseResponse handleAccessDeniedException(AccessDeniedException ex){
		String msg = RespCode.ERROR_403_A0301.getMessage() + ":" + ex.getMessage();
		BaseResponse response = RestResponse.error(RespCode.ERROR_403_A0301);
		response.setMessage(msg);
		return response;
	}

	@ResponseStatus(UNAUTHORIZED)
	@ExceptionHandler({AuthenticationException.class, AuthenticationCredentialsNotFoundException.class})
	public BaseResponse handleAuthenticationException(AuthenticationException ex){
		String msg = RespCode.ERROR_401_A0312.getMessage() + ":" + ex.getMessage();
		return BaseResponse.builder().message(msg)
				.errorCode(RespCode.ERROR_401_A0312.getErrorCode())
				.status(UNAUTHORIZED.value()).build();
	}

	// 系统基本异常处理
	@ExceptionHandler({BaseException.class})
	public BaseResponse handlerBaseException(BaseException ex) {
		return BaseResponse.builder().message(ex.getMessage())
				.errorCode(ex.getErrorCode()).status(HttpStatus.OK.value())
				.build();
	}

	@ResponseStatus(INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	public BaseResponse handlerException(Exception ex) {
		return BaseResponse.builder().message(ex.getMessage())
				.errorCode(RespCode.ERROR_500_B0001.getErrorCode())
				.status(RespCode.ERROR_500_B0001.getStatus())
				.build();
	}

}
