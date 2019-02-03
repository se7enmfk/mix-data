/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.se7en.biz.common.model.BaseObject;

import java.io.Serializable;
import java.util.List;

/**
 * null
 *
 * @author se7en zhou
 * @since 2019-01-10 16:04:57
 */
@TableName("PRO_DATA_TYPE")
public class ProDataType extends BaseObject<ProDataType> implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private int id;

    /**
     * name
     */
    private String name;

    private String p_id;

    private String p_name;

    @TableField(exist = false)
    private String content;
    /**
     * show_order
     */
    private Long show_order;
    @TableField(exist = false)
    private List<ProDataType> list;

    public String getContent() {
        return content;
    }

    public String getP_id() {
        return p_id;
    }

    public ProDataType setP_id(String p_id) {
        this.p_id = p_id;
        return this;
    }

    public String getP_name() {
        return p_name;
    }

    public ProDataType setP_name(String p_name) {
        this.p_name = p_name;
        return this;
    }

    public ProDataType setContent(String content) {
        this.content = content;
        return this;
    }

    public List<ProDataType> getList() {
        return list;
    }

    public ProDataType setList(List<ProDataType> list) {
        this.list = list;
        return this;
    }

    public int getId() {
        return id;
    }

    public ProDataType setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public ProDataType setName(String name) {
        this.name = name;
        return this;
    }

    public Long getShow_order() {
        return this.show_order;
    }

    public ProDataType setShow_order(Long show_order) {
        this.show_order = show_order;
        return this;
    }

    @Override
    public String toString() {
        return "ProDataType {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", show_order='" + show_order + '\'' +
                '}';
    }
}
