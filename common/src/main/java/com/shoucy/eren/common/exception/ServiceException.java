package com.shoucy.eren.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 业务异常
 *
 * @author shoucy
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException {

	/**
	 * 错误码
	 */
	private Integer code;

	/**
	 * 错误提示
	 */
	private String message;

	/**
	 * 错误明细
	 */
	private String detailMessage;

}