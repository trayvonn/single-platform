package com.single.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.single.platform.base.BaseEntity;
import lombok.Data;

/**
 * 员工表
 *
 * @author: 吴邪
 * @date: 2020/5/13 11:55
 */
@Data
@TableName("t_users")
public class Users extends BaseEntity {

    /**
     * 员工id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 花名
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 微信openid
     */
    @TableField("open_id")
    private String openId;

    /**
     * 微信unionid
     */
    @TableField("union_id")
    private String unionId;

    /**
     * 职级
     */
    @TableField("job_level")
    private Integer jobLevel;

    /**
     * 职称
     */
    @TableField("job_title")
    private Integer jobTitle;

    /**
     * 上级id
     */
    @TableField("leader_id")
    private Integer leaderId;

    /**
     * 是否领导 0:否，1:是
     */
    @TableField("is_leader")
    private Integer isLeader;

    /**
     * 部门id
     */
    @TableField("org_id")
    private Integer orgId;
}
