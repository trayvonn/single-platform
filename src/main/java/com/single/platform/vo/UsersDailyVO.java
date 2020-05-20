package com.single.platform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: 吴邪
 * @date: 2020/5/15 14:24
 */
@ApiModel("用户日报展示类")
@Data
@AllArgsConstructor
public class UsersDailyVO {

    /**
     * 员工id
     */
    @ApiModelProperty(value = "员工id",dataType = "Integer")
    private Integer id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名",dataType = "String")
    private String name;

    /**
     * 花名
     */
    @ApiModelProperty(value = "花名",dataType = "String")
    private String nickName;

    /**
     * 职级
     */
    @ApiModelProperty(value = "职级",dataType = "Integer")
    private Integer jobLevel;

    /**
     * 职称
     */
    @ApiModelProperty(value = "职称",dataType = "String")
    private String jobTitle;

    /**
     * 是否领导 0:否，1:是
     */
    @ApiModelProperty(value = "是否领导",dataType = "Integer")
    private Integer isLeader;

    /**
     * 日报对象
     */
    @ApiModelProperty(value = "日报对象")
    private List<DailyVO> daily;
}
