package com.tanwan.config.exception;

import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class ApiException extends RuntimeException {

    private int code;
    private String msg;

    public ApiException() {
        this(500, "接口错误");
    }

    public ApiException(String msg) {
        this(500, msg);
    }

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}