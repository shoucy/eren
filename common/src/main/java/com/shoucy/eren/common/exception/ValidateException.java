package com.shoucy.eren.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 校验异常
 *
 * @author shoucy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ValidateException extends RuntimeException {

    public ValidateException(Throwable e) {
        super(e.getMessage(), e);
    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
