package com.example.wechat.controller;

import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.example.wechat.common.Result;
import com.example.wechat.constant.WechatConstant;
import com.example.wechat.response.WechatUserInfoResponse;
import com.example.wechat.utils.WechatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信api控制器
 *
 * @author fu.yuanming
 * @date 2021-07-27
 */
@RestController
@RequestMapping("/wechat")
@Slf4j
public class WechatApiController {

    @PostMapping("/get-userinfo")
    public Result<WechatUserInfoResponse> getUserInfo(@RequestParam String code) {
        log.info("临时登录code: {}", code);
        Map<String, String> paramMap = new HashMap<>(16);
        paramMap.put("APPID", WechatConstant.APPID);
        paramMap.put("SECRET", WechatConstant.SRCRET);
        paramMap.put("JSCODE", code);
        HttpResponse response = WechatUtil.httpGet(WechatConstant.CODE2_SESSION, paramMap);
        log.info("调用微信code2Session接口，获取响应结果：{}", response);
        return Result.success(JSONUtil.toBean(response.body(), WechatUserInfoResponse.class));
    }

}
