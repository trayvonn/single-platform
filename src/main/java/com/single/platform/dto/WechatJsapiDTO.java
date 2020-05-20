package com.single.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: 吴邪
 * @date: 2020/5/19 18:21
 */
@Data
@AllArgsConstructor
public class WechatJsapiDTO {
    private String noncestr;
    private long timestamp;
    private String signature;
}
