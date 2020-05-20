package com.single.platform.enums;

import lombok.AllArgsConstructor;

/**
 * HTTP状态枚举类
 * @author: 吴邪
 * @date: 2020/5/13 15:20
 */
@AllArgsConstructor
public enum HttpEnum {
    SUCCESS(0,"成功"),
    EXCEPTION(999,"异常"),

    WECHAT_CODE_INVALID(101,"CODE无效");


    public int code;
    public String msg;
}
