package com.single.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: 吴邪
 * @date: 2020/5/18 16:30
 */
@Data
@TableName("t_timesheet")
public class Timesheet  {

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * job_title
     */
    @TableField("job_title")
    private String jobTitle;

    /**
     * name
     */
    @TableField("name")
    private String name;

    /**
     * leader_name
     */
    @TableField("leader_name")
    private String leaderName;

    /**
     * application
     */
    @TableField("application")
    private String application;

    /**
     * module
     */
    @TableField("module")
    private String module;

    /**
     * action
     */
    @TableField("action")
    private String action;

    /**
     * status
     */
    @TableField("status")
    private String status;

    /**
     * description
     */
    @TableField("description")
    private String description;

    /**
     * create_time
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * estimated_time
     */
    @TableField("estimated_time")
    private BigDecimal estimatedTime;
}
