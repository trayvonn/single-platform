package com.single.platform.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author: 吴邪
 * @date: 2020/5/15 11:45
 */
@ApiModel("日报展示类")
@Data
@AllArgsConstructor
public class DailyVO {

    /**
     * 日报id
     */
    @ApiModelProperty(value = "日报id",dataType = "Integer")
    private Integer id;

    /**
     * 员工id
     */
    @ApiModelProperty(value = "员工id",dataType = "Integer")
    private Integer userId;

    /**
     * 项目信息
     */
    @ApiModelProperty(value = "项目信息")
    private ProjectsVO projects;

    /**
     * 行为
     */
    @ApiModelProperty(value = "行为",dataType = "String")
    private String action;

    /**
     * 日报状态
     */
    @ApiModelProperty(value = "日报状态",dataType = "String")
    private String status;

    /**
     * 日报内容
     */
    @ApiModelProperty(value = "日报内容",dataType = "String")
    private String content;

    /**
     * 预估工时 填小时单位，整数
     */
    @ApiModelProperty(value = "预估工时",dataType = "Integer")
    private Integer estimatedTime;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
}
