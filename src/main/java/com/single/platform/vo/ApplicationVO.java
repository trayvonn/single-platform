package com.single.platform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: 吴邪
 * @date: 2020/5/15 10:38
 */
@ApiModel("工程展示类")
@Data
@AllArgsConstructor
public class ApplicationVO {
    /**
     * 工程编号
     */
    @ApiModelProperty(value = "工程编号",dataType = "String")
    private String code;

    /**
     * 工程名称
     */
    @ApiModelProperty(value = "工程名称",dataType = "String")
    private String name;

    /**
     * 负责人姓名
     */
    @ApiModelProperty(value = "负责人姓名",dataType = "String")
    private String ownerName;
}
