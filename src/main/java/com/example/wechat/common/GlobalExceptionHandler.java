package com.example.wechat.common;

import com.example.wechat.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author fu.yuanming
 * @date 2021-07-30
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result<String> exceptionHandler(Exception e) {
        return Result.error();
    }

}
