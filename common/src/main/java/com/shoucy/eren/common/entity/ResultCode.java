package com.shoucy.eren.common.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 返回状态码
 *
 * @author shoucy
 */
@Getter
@RequiredArgsConstructor
public enum ResultCode {

    SUCCESS(200, "操作成功"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "拒绝请求"),
    ERROR(500, "系统内部错误"),
    WARN(601, "系统警告消息");

    private final Integer code;

    private final String msg;

}
