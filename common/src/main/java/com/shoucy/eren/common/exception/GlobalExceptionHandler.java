package com.shoucy.eren.common.exception;

import com.shoucy.eren.common.entity.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author shoucy
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 系统异常
	 */
	@ExceptionHandler(Exception.class)
	public Result<?> handleException(Exception e, HttpServletRequest request) {
		String requestUri = request.getRequestURI();
		log.error("请求地址'{}',发生系统异常.", requestUri, e);
		return Result.fail("后台异常");
	}

}
