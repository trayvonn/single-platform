package com.single.platform.enums;

import lombok.AllArgsConstructor;

/**
 * 行为枚举类
 * @author: 吴邪
 * @date: 2020/5/18 16:08
 */
@AllArgsConstructor
public enum DailyActionEnum {

    RequirementAnalysis(1),
    ProductDesign(2),
    UIDesign(3),
    Programming(4),
    Testing(5),
    Operating(6),
    OnlineFollow(7),
    Other(8);

    int value;
}
