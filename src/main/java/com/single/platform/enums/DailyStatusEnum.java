package com.single.platform.enums;

import lombok.AllArgsConstructor;

/**
 * 日报状态枚举类
 * @author: 吴邪
 * @date: 2020/5/18 16:15
 */
@AllArgsConstructor
public enum DailyStatusEnum {

    InProgress(1),
    Completed(2);

    int value;
}
