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
import java.math.BigDecimal;
import java.util.List;

/**
 * null
 *
 * @author se7en zhou
 * @since 2019-01-10 15:44:53
 */
@TableName("PRO_DATA")
public class ProData extends BaseObject<ProData> implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private int id;

    private int area_id;

    /**
     * data_dt
     */
    private String data_dt;


    /**
     * data_value
     */
    private BigDecimal data_value;

    @TableField(exist = false)
    private List<ProData> list;

    @TableField(exist = false)
    private String data_dt_start;
    @TableField(exist = false)
    private String data_dt_end;

    public String getData_dt_start() {
        return data_dt_start;
    }

    public ProData setData_dt_start(String data_dt_start) {
        this.data_dt_start = data_dt_start;
        return this;
    }

    public int getArea_id() {
        return area_id;
    }

    public ProData setArea_id(int area_id) {
        this.area_id = area_id;
        return this;
    }

    public String getData_dt_end() {
        return data_dt_end;
    }

    public ProData setData_dt_end(String data_dt_end) {
        this.data_dt_end = data_dt_end;
        return this;
    }

    public List<ProData> getList() {
        return list;
    }

    public ProData setList(List<ProData> list) {
        this.list = list;
        return this;
    }

    public int getId() {
        return this.id;
    }

    public ProData setId(int id) {
        this.id = id;
        return this;
    }

    public String getData_dt() {
        return this.data_dt;
    }

    public ProData setData_dt(String data_dt) {
        this.data_dt = data_dt;
        return this;
    }

    public BigDecimal getData_value() {
        return this.data_value;
    }

    public ProData setData_value(BigDecimal data_value) {
        this.data_value = data_value;
        return this;
    }

    @Override
    public String toString() {
        return "ProData {" +
                "id='" + id + '\'' +
                ", data_dt='" + data_dt + '\'' +
                ", data_value='" + data_value + '\'' +
                '}';
    }
}
