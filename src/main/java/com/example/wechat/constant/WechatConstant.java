package com.example.wechat.constant;

/**
 * 微信常量
 *
 * @author fu.yuanming
 * @date 2021-07-27
 */
public class WechatConstant {

    /**
     * appid
     */
    public static final String APPID = "wxb589743533067db2";

    /**
     * srcret
     */
    public static final String SRCRET = "6a1f96e147deeb9ebfdbab1aa6db57d2";

    /**
     * grent类型
     */
    public static final String GRENT_TYPE = "authorization_code";

    /**
     * 微信code2Session接口请求地址
     */
    public static final String CODE2_SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET" +
            "&js_code=JSCODE&grant_type=authorization_code";

}
