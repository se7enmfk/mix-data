/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.common.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.plugins.Page;
import com.ftx.frame.util.string.StringUtil;

import java.io.Serializable;

public abstract class BaseObject<T> implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 6086153321336890627L;

    @TableField(exist = false)
    private Page<T> page;
    /**
     * token信息
     */
    @TableField(exist = false)
    private String token;

    @TableField(exist = false)
    private String submit_status;
    /**
     * 排序
     */
    @TableField(exist = false)
    private String order_cause_;

    /**
     * 排序字段
     */
    @TableField(exist = false)
    private String order_by;

    /**
     * 页面状态，N新建，E修改，V查看
     */
    @TableField(exist = false)
    private String mode_;

    /**
     * 是否更新全部column
     */
    @TableField(exist = false)
    private String all_ind_;


    public String getOrder_by() {
        return order_by;
    }

    public BaseObject<T> setOrder_by(String order_by) {
        this.order_by = order_by;
        return this;
    }
    public String getAll_ind_() {
        return all_ind_;
    }

    public BaseObject setAll_ind_(String all_ind_) {
        this.all_ind_ = all_ind_;
        return this;
    }


    public String getMode_() {
        return mode_;
    }

    public BaseObject setMode_(String mode_) {
        this.mode_ = mode_;
        return this;
    }

    public String getSubmit_status() {
        return submit_status;
    }

    public BaseObject<T> setSubmit_status(String submit_status) {
        this.submit_status = submit_status;
        return this;
    }

    public String getToken() {
        return token;
    }

    public BaseObject setToken(String token) {
        this.token = token;
        return this;
    }


    public String getOrder_cause_() {
        return order_cause_;
    }

    public Page<T> getPage() {
        return page;
    }

    public BaseObject<T> setPage(Page<T> page) {
        this.page = page;
        return this;
    }

    /**
     * 防止sql注入
     */
    public BaseObject setOrder_cause_(String order_cause_) {
        this.order_cause_ = StringUtil.preventSQLInjection(order_cause_);
        return this;
    }

    @Override
    public String toString() {
        return "BaseObject{" +
                "page=" + page +
                ", token='" + token + '\'' +
                ", submit_status='" + submit_status + '\'' +

                ", order_cause_='" + order_cause_ + '\'' +
                ", order_by='" + order_by + '\'' +
                ", mode_='" + mode_ + '\'' +
                ", all_ind_='" + all_ind_ + '\'' +
                '}';
    }
}
