package com.go.demo.controller;

import com.go.demo.common.enums.SystemCodeEnums;
import com.go.demo.common.exception.AppException;
import com.go.demo.common.response.BasicResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * http请求的方法不正确
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public BasicResult httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        logger.error(e.getMessage(), e);
        return SystemCodeEnums.fail.applyVal("HTTP请求方法错误");
    }

    /**
     * 请求参数不全
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public BasicResult missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        logger.error(e.getMessage(), e);
        return SystemCodeEnums.fail.applyVal("缺失请求参数错误");
    }

    /**
     * 请求参数类型不正确
     */
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public BasicResult typeMismatchExceptionHandler(TypeMismatchException e) {
        logger.error(e.getMessage(), e);
        return SystemCodeEnums.fail.applyVal("请求参数类型不正确");
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(AppException.class)
    @ResponseBody
    public BasicResult allExceptionHandler(AppException e) {
        logger.error(e.getMessage(), e);
        BasicResult result = new BasicResult();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return result;
    }

    /**
     * 其他异常
     */
    @ExceptionHandler
    @ResponseBody
    public BasicResult allExceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return SystemCodeEnums.fail.applyVal();
    }
}
