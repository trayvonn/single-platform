package com.single.platform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author: 吴邪
 * @date: 2020/5/15 10:15
 */
@ApiModel("项目展示类")
@Data
@AllArgsConstructor
public class ProjectsVO {

    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id",dataType = "Integer")
    private Integer id;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称",dataType = "String")
    private String name;

    /**
     * 项目编号 project code
     */
    @ApiModelProperty(value = "项目编号",dataType = "String")
    private String pcode;

    /**
     * 需求编号 钉钉需求编号，暂时和项目编号保持一致
     */
    @ApiModelProperty(value = "需求编号",dataType = "String")
    private String rcode;

    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人",dataType = "String")
    private String ownerName;

    /**
     * 立项日期
     */
    @ApiModelProperty(value = "立项日期",dataType = "Date")
    private Date projectTime;

    /**
     * 优先级
     */
    @ApiModelProperty(value = "优先级",dataType = "String")
    private String priority;

    /**
     * 预估天数
     */
    @ApiModelProperty(value = "预估天数",dataType = "Integer")
    private Integer estimatedDays;

    /**
     * 工程对象
     */
    @ApiModelProperty(value = "工程对象")
    private ApplicationVO application;

}
