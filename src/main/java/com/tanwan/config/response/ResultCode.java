package com.tanwan.config.response;

import lombok.Getter;

/**
 * 响应码枚举
 */
@Getter
public enum ResultCode {

    SUCCESS(200, "操作成功"),

    FAILED(500, "响应失败"),

    VALIDATE_FAILED(501, "参数校验失败"),

    ERROR(502, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}