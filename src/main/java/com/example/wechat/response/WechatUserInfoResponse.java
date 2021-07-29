package com.example.wechat.response;

import lombok.Data;

/**
 * 微信用户信息响应类
 *
 * @author fu.yuanming
 * @date 2021-07-27
 */
@Data
public class WechatUserInfoResponse {

    /**
     * openid
     */
    private String openid;

    /**
     * unionid
     */
    private String unionid;

    /**
     * 会话密钥
     */
    private String session_key;

}
