package com.single.platform.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 吴邪
 * @date: 2020/5/14 11:52
 */
@Data
@Configuration
@ConfigurationProperties("wechat")
public class WechatProperties {

    private String appId;

    private String appSecret;

    private String accessTokenUrl ="https://api.weixin.qq.com/sns/oauth2/access_token";

    private String refreshTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

    private String checkTokenUrl = "https://api.weixin.qq.com/sns/auth";

    private String ticketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";


}
