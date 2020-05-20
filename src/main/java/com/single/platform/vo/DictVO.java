package com.single.platform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: 吴邪
 * @date: 2020/5/14 15:54
 */
@ApiModel("字典展示类")
@Data
public class DictVO implements Serializable {

    @ApiModelProperty(value = "字典类型",dataType = "string")
    private String type;
    @ApiModelProperty(value = "字典值",dataType = "Integer")
    private Integer value;
    @ApiModelProperty(value = "字典码",dataType = "string")
    private String code;
    @ApiModelProperty(value = "字典标签",dataType = "string")
    private String label;
    @ApiModelProperty(value = "字典描述",dataType = "string")
    private String description;
}
