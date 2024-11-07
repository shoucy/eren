package com.shoucy.eren.common.entity;

import lombok.Data;

/**
 * 标准响应信息实体
 */
@Data
public class Result<T> {

    /**
     * 返回状态码，200为成功
     */
    private int code;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应信息，比异常的提示，警告，提示语等
     */
    private String message;

    public static <T> Result<T> ok() {
        return build(ResultCode.SUCCESS.getCode(), null, "操作成功");
    }

    public static <T> Result<T> ok(T data) {
        return build(ResultCode.SUCCESS.getCode(), data, "操作成功");
    }

    public static <T> Result<T> ok(T data, String msg) {
        return build(ResultCode.SUCCESS.getCode(), data, msg);
    }

    public static <T> Result<T> fail() {
        return build(ResultCode.ERROR.getCode(), null, "操作失败");
    }

    public static <T> Result<T> fail(String msg) {
        return build(ResultCode.ERROR.getCode(), null, msg);
    }

    public static <T> Result<T> fail(T data) {
        return build(ResultCode.ERROR.getCode(), data, "操作失败");
    }

    public static <T> Result<T> fail(T data, String msg) {
        return build(ResultCode.ERROR.getCode(), data, msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return build(code, null, msg);
    }

    private static <T> Result<T> build(int code, T data, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }
}