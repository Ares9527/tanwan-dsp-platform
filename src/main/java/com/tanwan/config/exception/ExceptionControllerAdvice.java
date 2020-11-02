package com.tanwan.config.exception;

import com.tanwan.config.response.ResultCode;
import com.tanwan.config.response.ResultData;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResultData<String> ExceptionHandler(Exception e) {
        return new ResultData<>(ResultCode.FAILED, e.getMessage());
    }

    @ExceptionHandler(ApiException.class)
    public ResultData<String> APIExceptionHandler(ApiException e) {
        return new ResultData<>(ResultCode.FAILED, e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultData<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultData<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

}