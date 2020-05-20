package com.single.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.single.platform.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 日报表
 *
 * @author: 吴邪
 * @date: 2020/5/14 14:01
 */
@Data
@ApiModel("日报对象")
@TableName("t_daily")
@NoArgsConstructor
public class Daily extends BaseEntity {
    /**
     * 日报id
     */
    @ApiModelProperty(value = "日报id，新增不用填",dataType = "Integer")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id
     */
    @ApiModelProperty(value = "员工id",dataType = "Integer")
    @TableField("user_id")
    private Integer userId;

    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id",dataType = "Integer")
    @TableField("project_id")
    private Integer projectId;

    /**
     * 行为
     */
    @ApiModelProperty(value = "行为",dataType = "Integer")
    @TableField("action")
    private Integer action;

    /**
     * 日报状态
     */
    @ApiModelProperty(value = "日报状态",dataType = "Integer")
    @TableField("status")
    private Integer status;

    /**
     * 日报内容
     */
    @ApiModelProperty(value = "日报内容",dataType = "String")
    @TableField("content")
    private String content;

    /**
     * 预估工时 填小时单位，整数
     */
    @ApiModelProperty(value = "预估工时 填小时单位，整数",dataType = "Integer")
    @TableField("estimated_time")
    private Integer estimatedTime;

    public Daily(Integer id, Integer userId, Integer projectId, Integer action, Integer status, String content, Integer estimatedTime, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.projectId = projectId;
        this.action = action;
        this.status = status;
        this.content = content;
        this.estimatedTime = estimatedTime;
        this.setCreateTime(createTime);
    }
}
