package com.single.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.single.platform.base.BaseEntity;
import lombok.Data;

/**
 * 字典表
 *
 * @author: 吴邪
 * @date: 2020/5/14 14:04
 */
@Data
@TableName("t_dict")
public class Dict extends BaseEntity {

    /**
     * 字典id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 字典类型
     */
    @TableField("type")
    private String type;

    /**
     * 字典值
     */
    @TableField("value")
    private Integer value;

    /**
     * 字典码
     */
    @TableField("code")
    private String code;

    /**
     * 字典标签
     */
    @TableField("label")
    private String label;

    /**
     * 描述
     */
    @TableField("description")
    private String description;
}
