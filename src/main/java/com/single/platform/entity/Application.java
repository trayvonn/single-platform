package com.single.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.single.platform.base.BaseEntity;
import lombok.Data;

/**
 * 工程表
 *
 * @author: 吴邪
 * @date: 2020/5/14 13:55
 */
@Data
@TableName("t_application")
public class Application extends BaseEntity {
    /**
     * 工程id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 工程编号
     */
    @TableField("code")
    private String code;

    /**
     * 工程名称
     */
    @TableField("name")
    private String name;

    /**
     * 负责人id
     */
    @TableField("owner_id")
    private Integer ownerId;

}
