package com.single.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.single.platform.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 项目表
 *
 * @author: 吴邪
 * @date: 2020/5/14 14:06
 */
@Data
@TableName("t_projects")
public class Projects extends BaseEntity {

    /**
     * 项目id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 项目名称
     */
    @TableField("name")
    private String name;

    /**
     * 项目编号 project code
     */
    @TableField("pcode")
    private String pcode;

    /**
     * 需求编号 钉钉需求编号，暂时和项目编号保持一致
     */
    @TableField("rcode")
    private String rcode;

    /**
     * 负责人
     */
    @TableField("owner_id")
    private Integer ownerId;

    /**
     * 立项日期
     */
    @TableField("project_time")
    private Date projectTime;

    /**
     * 优先级
     */
    @TableField("priority")
    private Integer priority;

    /**
     * 预估天数
     */
    @TableField("estimated_days")
    private Integer estimatedDays;

    /**
     * 落地应用工程
     */
    @TableField("application_id")
    private Integer applicationId;
}
