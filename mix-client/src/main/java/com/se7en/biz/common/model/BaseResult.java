/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.common.model;


import com.se7en.biz.Constant;

/**
 * Description: Usage
 * Author: Kakus
 * CreateTime: 2016/11/27 20:56
 */
public class BaseResult<T> {

    private String code;
    private String msg;

    private T entity;

    public BaseResult() {
    }

    public BaseResult(String code) {
        this.code = code;
    }

    public BaseResult(int code, String msg) {
        this.code = code + "";
        this.msg = msg;
    }

    public BaseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(int code, String msg, T entity) {
        this.code = code + "";
        this.msg = msg;
        this.entity = entity;
    }

    public BaseResult(String code, String msg, T entity) {
        this.code = code;
        this.msg = msg;
        this.entity = entity;
    }
    public BaseResult(String code, T entity) {
        this.code = code;
        this.entity = entity;
    }

    public BaseResult(T entity) {
        this.code = Constant.CODE_200;
        this.msg = Constant.MSG_200;
        this.entity = entity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public int getIntCode(){
        return Integer.parseInt(this.code);
    }
}
