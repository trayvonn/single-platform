package com.single.platform.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 吴邪
 * @date: 2020/5/14 15:18
 */
@Data
public class WechatAccessTokenDTO implements Serializable {
    /**
     * 接口调用凭证
     */
    private String accessToken;
    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    private Integer expiresIn;
    /**
     * 用户刷新access_token
     */
    private String refreshToken;
    /**
     * 	授权用户唯一标识
     */
    private String openid;
    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */
    private String scope;
    /**
     * 当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。
     */
    private String unionid;
}
