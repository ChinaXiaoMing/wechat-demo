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

    /**
     * 自定义异常处理
     *
     * @param e 自定义异常
     * @return 通用返回类
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result<String> exceptionHandler(CustomException e) {
        log.error("自定义异常错误，错误码：【{}】, 错误信息：【{}】，堆栈异常信息：", e.getCode(), e.getMessage(), e);
        return Result.error(e.getCode(), e.getMessage());
    }

}
