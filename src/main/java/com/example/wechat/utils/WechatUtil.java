package com.example.wechat.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.Map;

/**
 * 微信工具类
 *
 * @author fu.yuanming
 * @date 2021-07-27
 */
public class WechatUtil {

    /**
     * http get请求
     *
     * @param url      请求地址
     * @param paramMap 请求参数对
     * @return {@link HttpResponse}
     */
    public static HttpResponse httpGet(String url, Map<String, String> paramMap) {
        if (CollUtil.isNotEmpty(paramMap)) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                url = url.replace(entry.getKey(), entry.getValue());
            }
        }
        return HttpRequest.get(url).execute();
    }

}
