package com.single.platform.enums;

import lombok.AllArgsConstructor;

/**
 * 职称枚举类
 * @author: 吴邪
 * @date: 2020/5/18 16:16
 */
@AllArgsConstructor
public enum JobTitleEnum {

    ProductManager(1),
    Tester(2),
    Designer(3),
    Operator(4),
    DataDeveloper(5),
    TechDirector(6),
    BusinessOperator(7),
    FrontendDeveloper(8),
    BackendDeveloper(9);

    int value;
}
