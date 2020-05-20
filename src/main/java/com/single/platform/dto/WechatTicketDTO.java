package com.single.platform.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 吴邪
 * @date: 2020/5/14 15:18
 */
@Data
public class WechatTicketDTO implements Serializable {
    /**
     * 接口调用凭证
     */
    private String ticket;
    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    private Integer expiresIn;
}
