package com.example.wechat.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误枚举
 *
 * @author fu.yuanming
 * @date 2021-08-02
 */
@AllArgsConstructor
public enum Error {

    /**
     * 导出文件错误
     */
    ERROR_EXPORT(50001, "导出文件错误"),
    /**
     * 导出数据为空
     */
    ERROR_EXPORT_EMPTY(50002, "导出数据为空");

    /**
     * 状态码
     */
    @Getter
    private int code;

    /**
     * 提示信息
     */
    @Getter
    private String massage;

}
